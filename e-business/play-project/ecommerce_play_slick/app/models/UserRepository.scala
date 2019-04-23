package models

import app.models.User
import javax.inject.{Inject, Singleton}
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile
import play.api.Logger

import scala.concurrent.{ExecutionContext, Future}

/**
  * A repository for people.
  *
  * @param dbConfigProvider The Play db config provider. Play will inject this for you.
  */
@Singleton
class UserRepository @Inject() (dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext) {
  // We want the JdbcProfile for this provider
  val dbConfig = dbConfigProvider.get[JdbcProfile]

  val logger: Logger = Logger(this.getClass())

  // These imports are important, the first one brings db into scope, which will let you do the actual db operations.
  // The second one brings the Slick DSL into scope, which lets you define the table and other queries.
  import dbConfig._
  import profile.api._

  /**
    * Here we define the table. It will have a name of people
    */
   class UsersTable(tag: Tag) extends Table[User](tag, "user") {

    /** The ID column, which is the primary key, and auto incremented */
    def id = column[Long]("user_id", O.PrimaryKey, O.AutoInc)

    def name = column[String]("user_name")

    def password = column[String]("user_password")

    def email = column[String]("user_email")

    def country = column[String]("user_country")

    def street = column[String]("user_street")

    def city = column[String]("user_city")

    def address = column[String]("user_address")

    def postal = column[String]("user_postal")

//    def category_fk = foreignKey("cat_fk",category, cat)(_.id)


    /**
      * This is the tables default "projection".
      *
      * It defines how the columns are converted to and from the Person object.
      *
      * In this case, we are simply passing the id, name and page parameters to the Person case classes
      * apply and unapply methods.
      */
    def * = (id, name, password, email, country, street, city, address, postal) <> ((User.apply _).tupled, User.unapply)
  }

  /**
    * The starting point for all queries on the people table.
    */
  private val users = TableQuery[UsersTable]

  /**
    * Create a person with the given name and age.
    *
    * This is an asynchronous operation, it will return a future of the created person, which can be used to obtain the
    * id for that person.
    */
  def create(name: String, password: String, email: String,
             country: String, street: String, city: String, address: String, postal: String): Future[User] = db.run {
    // We create a projection of just the name and age columns, since we're not inserting a value for the id column
    (users.map(p => (p.name, p.password, p.email, p.country, p.street, p.city, p.address, p.postal))
      // Now define it to return the id, because we want to know what id was generated for the person
      returning users.map(_.id)
      // And we define a transformation for the returned value, which combines our original parameters with the
      // returned id
//      into ((user, id) => User(id, user._1, user._2, user._3, user._4, user._5, user._6, user._7, user._8))
      into {case ((name, password, email, country, street, city, address, postal),id) => User(id,name, password, email, country, street, city, address, postal)}
      // And finally, insert the person into the database
      ) += (name, password, email, country, street, city, address, postal)
  }

  /**
    * List all the people in the database.
    */
  def list(): Future[Seq[User]] = db.run {
    users.result
  }

}
