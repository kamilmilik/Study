package models

import app.models.Order
import javax.inject.{Inject, Singleton}
import play.api.Logger
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class OrderRepository @Inject() (dbConfigProvider: DatabaseConfigProvider,  userRepository: UserRepository)(implicit ec: ExecutionContext) {
  // We want the JdbcProfile for this provider
  private val dbConfig = dbConfigProvider.get[JdbcProfile]

  val logger: Logger = Logger(this.getClass())

  // These imports are important, the first one brings db into scope, which will let you do the actual db operations.
  // The second one brings the Slick DSL into scope, which lets you define the table and other queries.
  import dbConfig._
  import profile.api._
  import userRepository.UsersTable

  private class OrderTable(tag: Tag) extends Table[Order](tag, "order") {

    /** The ID column, which is the primary key, and auto incremented */
    def id = column[Long]("order_id", O.PrimaryKey, O.AutoInc)

    def user_id = column[Long]("user_id")

    def order_date = column[String]("order_date")

    def order_address = column[String]("order_address")

    def user_fk = foreignKey("user_fk",user_id, user)(_.id)

    def * = (id, user_id, order_date, order_address) <> ((Order.apply _).tupled, Order.unapply)
  }

  private val order = TableQuery[OrderTable]

  private val user = TableQuery[UsersTable]

  def create(userId: Long, orderDate: String, orderAddress: String): Future[Order] = db.run {
    // We create a projection of just the name and age columns, since we're not inserting a value for the id column
    (order.map(p => (p.user_id, p.order_date, p.order_address))
      // Now define it to return the id, because we want to know what id was generated for the person
      returning order.map(_.id)
      // And we define a transformation for the returned value, which combines our original parameters with the
      // returned id
      into {case ((userId, orderDate, orderAddress),id) => Order(id, userId, orderDate, orderAddress)}
      ) += (userId, orderDate, orderAddress)
  }

  def list(): Future[Seq[Order]] = db.run {
    order.result
  }

}
