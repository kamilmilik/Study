package controllers

import javax.inject._
import models.UserRepository
import play.api.data.Form
import play.api.data.Forms._
import play.api.data.validation.Constraints.{max, min}
import play.api.libs.json.Json
import play.api.mvc._
import play.api.Logger

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class UsersController @Inject()(repo: UserRepository,
                                 cc: MessagesControllerComponents
                                )(implicit ec: ExecutionContext)
  extends MessagesAbstractController(cc) {
  val logger: Logger = Logger(this.getClass())

  /**
    * The mapping for the person form.
    */
  val userRegistrationForm: Form[RegistrationUserForm] = Form {
    mapping(
      "name" -> nonEmptyText,
      "password" -> nonEmptyText,
      "email" -> email,
      "country" -> nonEmptyText,
      "street" -> nonEmptyText,
      "city" -> nonEmptyText,
      "address" -> nonEmptyText,
      "postal" -> nonEmptyText
    )(RegistrationUserForm.apply)(RegistrationUserForm.unapply)
  }

  val userLoginForm: Form[LoginUserForm] = Form {
    mapping(
      "email" -> email,
      "password" -> nonEmptyText
    )(LoginUserForm.apply)(LoginUserForm.unapply)
  }

  /**
    * The index action.
    */
  def registration = Action { implicit request =>
    Ok(views.html.users.registration(userRegistrationForm))
  }

  def login = Action { implicit request =>
    Ok(views.html.users.login(userLoginForm))
  }

  /**
    * The add person action.
    *
    * This is asynchronous, since we're invoking the asynchronous methods on PersonRepository.
    */
  def add = Action.async { implicit request =>
    // Bind the form first, then fold the result, passing a function to handle errors, and a function to handle succes.
    userRegistrationForm.bindFromRequest.fold(
      // The error function. We return the index page with the error form, which will render the errors.
      // We also wrap the result in a successful future, since this action is synchronous, but we're required to return
      // a future because the person creation function returns a future.
        errorForm => {
          logger.debug("error " + errorForm)
          Future.successful(Ok(views.html.users.registration(errorForm)))
      },
      // There were no errors in the from, so create the person.
      user => {
        logger.debug("create ")
        repo.create(user.name, user.password, user.email, user.country, user.street, user.city, user.address, user.postal).map { _ =>
          // If successful, we simply redirect to the index page.
          Redirect(routes.UsersController.getUsers()).flashing("success" -> "user.created")
        }
      }
    )
  }

  /**
    * A REST endpoint that gets all the people as JSON.
    */
  def getUsers = Action.async { implicit request =>
    repo.list().map { users =>
      Ok(Json.toJson(users))
    }
  }

  def getById(id: String) = Action { Ok("") }

  def update(id: String) = Action { Ok("") }
}

case class RegistrationUserForm(name: String, password: String,  email: String,
                                country: String, street: String, city: String, address: String, postal: String)

case class LoginUserForm(email: String, password: String)
