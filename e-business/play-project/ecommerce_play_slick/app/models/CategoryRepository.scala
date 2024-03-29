package models

import app.models.Category
import javax.inject.{Inject, Singleton}
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile

import scala.concurrent.{ExecutionContext, Future}

/**
  * A repository for people.
  *
  * @param dbConfigProvider The Play db config provider. Play will inject this for you.
  */
@Singleton
class CategoryRepository @Inject() (dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext) {
  // We want the JdbcProfile for this provider
  val dbConfig = dbConfigProvider.get[JdbcProfile]

  // These imports are important, the first one brings db into scope, which will let you do the actual db operations.
  // The second one brings the Slick DSL into scope, which lets you define the table and other queries.
  import dbConfig._
  import profile.api._

  /**
    * Here we define the table. It will have a name of people
    */
  class CategoryTable(tag: Tag) extends Table[Category](tag, "category") {

    /** The ID column, which is the primary key, and auto incremented */
    def id = column[Int]("category_id", O.PrimaryKey, O.AutoInc)

    /** The name column */
    def name = column[String]("category_name")

    /**
      * This is the tables default "projection".
      *
      * It defines how the columns are converted to and from the Person object.
      *
      * In this case, we are simply passing the id, name and page parameters to the Person case classes
      * apply and unapply methods.
      */
    def * = (id, name) <> ((Category.apply _).tupled, Category.unapply)
  }

  /**
    * The starting point for all queries on the people table.
    */
  val category = TableQuery[CategoryTable]

  def create(name: String): Future[Category] = db.run {
    (category.map(c => (c.name))
      returning category.map(_.id)
      into {case ((name),id) => Category(id,name)}
      ) += (name)
  }

  /**
    * List all the people in the database.
    */
  def list(): Future[Seq[Category]] = db.run {
    category.result
  }

  def getById(category_id: Int): Future[Seq[Category]] = db.run {
    category.filter(_.id === category_id).result
  }
}
