package models

import app.models.Product
import javax.inject.{Inject, Singleton}
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile
import play.api.Logger

import scala.concurrent.{ExecutionContext, Future}

/**
  * A repository for product.
  *
  * @param dbConfigProvider The Play db config provider. Play will inject this for you.
  */
@Singleton
class ProductRepository @Inject() (dbConfigProvider: DatabaseConfigProvider,  categoryRepository: CategoryRepository)(implicit ec: ExecutionContext) {
  // We want the JdbcProfile for this provider
  protected val dbConfig = dbConfigProvider.get[JdbcProfile]

  val logger: Logger = Logger(this.getClass())

  // These imports are important, the first one brings db into scope, which will let you do the actual db operations.
  // The second one brings the Slick DSL into scope, which lets you define the table and other queries.
  import dbConfig._
  import profile.api._
  import categoryRepository.CategoryTable

  private class ProductTable(tag: Tag) extends Table[Product](tag, "product") {

    /** The ID column, which is the primary key, and auto incremented */
    def id = column[Long]("product_id", O.PrimaryKey, O.AutoInc)

    def name = column[String]("product_name")

    def description = column[String]("product_description")

    def price = column[Int]("product_price")

    def unavailable = column[String]("product_unavailable")

    def category = column[Int]("category_id")

    def category_fk = foreignKey("cat_fk",category, cat)(_.id)

    def * = (id, name, description, price, unavailable, category) <> ((Product.apply _).tupled, Product.unapply)
  }

  private val product = TableQuery[ProductTable]

  private val cat = TableQuery[CategoryTable]

  def create(name: String, description: String, price: Int, unavailable: String, category: Int): Future[Product] = db.run {
    // We create a projection of just the name and age columns, since we're not inserting a value for the id column
    (product.map(p => (p.name, p.description, p.price, p.unavailable, p.category))
      // Now define it to return the id, because we want to know what id was generated for the person
      returning product.map(_.id)
      // And we define a transformation for the returned value, which combines our original parameters with the
      // returned id
      into {case ((name, description, price, unavailable, category),id) => Product(id,name, description, price, unavailable, category)}
      ) += (name, description, price, unavailable, category)
  }

  def list(): Future[Seq[Product]] = db.run {
    product.result
  }

  def getById(product_id: Long): Future[Seq[Product]] = db.run {
    product.filter(_.id === product_id).result
  }

  def getByCategory(category_id: Int): Future[Seq[Product]] = db.run {
    product.filter(_.category === category_id).result
  }

  def getByCategories(category_ids: List[Int]): Future[Seq[Product]] = db.run {
    product.filter(_.category inSet category_ids).result
  }

}
