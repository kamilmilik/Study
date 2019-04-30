package controllers

import app.models.User
import javax.inject._
import models.{OrderRepository, UserRepository}
import play.api.Logger
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json.Json
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}

@Singleton
class OrdersController @Inject()(orderRepo: OrderRepository, userRepo: UserRepository,
                                cc: MessagesControllerComponents
                                  )(implicit ec: ExecutionContext)
  extends MessagesAbstractController(cc) {
  val logger: Logger = Logger(this.getClass())

  val orderForm: Form[CreateOrderForm] = Form {
    mapping(
      "user id" -> number,
      "order date" -> nonEmptyText,
      "order address" -> nonEmptyText
    )(CreateOrderForm.apply)(CreateOrderForm.unapply)
  }


  def get = Action.async { implicit request =>
    orderRepo.list().map { order =>
      Ok(Json.toJson(order))
    }
  }

  def getById(id: String) = Action { Ok("product id " + id) }

  def addOrderForm = Action.async { implicit request =>
    val users = userRepo.list()
    users.map(user => Ok(views.html.order.add_order(orderForm,user)))
    /*
    .onComplete{
    case Success(categories) => Ok(views.html.index(productForm,categories))
    case Failure(t) => print("")
  }*/
  }

  def add = Action.async { implicit request =>
    // Bind the form first, then fold the result, passing a function to handle errors, and a function to handle succes.
    var a:Seq[User] = Seq[User]()
    val users = userRepo.list().onComplete{
      case Success(cat) => a = cat
      case Failure(_) => print("fail")
    }

    orderForm.bindFromRequest.fold(
      // The error function. We return the index page with the error form, which will render the errors.
      // We also wrap the result in a successful future, since this action is synchronous, but we're required to return
      // a future because the person creation function returns a future.
      errorForm => {
        logger.info("error: " + errorForm)
        Future.successful(
          Ok(views.html.order.add_order(errorForm,a))
        )
      },
      // There were no errors in the from, so create the person.
      order => {
        orderRepo.create(order.userId, order.orderDate, order.orderAddress).map { _ =>
          // If successful, we simply redirect to the index page.
          Redirect(routes.OrdersController.get).flashing("success" -> "product.created")
        }
      }
    )
  }

    def getById(id: Long) = Action.async { implicit  request =>
      orderRepo.getById(id).map { order =>
        Ok(Json.toJson(order))
      }
    }


  def update(id: String) = Action { Ok("") }

}

case class CreateOrderForm(userId: Int, orderDate: String, orderAddress: String)