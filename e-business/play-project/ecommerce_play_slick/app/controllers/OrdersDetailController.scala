package controllers

import app.models.Order
import javax.inject._
import models.{OrderDetailRepository, OrderRepository, ProductRepository, UserRepository}
import play.api.Logger
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json.Json
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}

@Singleton
class OrdersDetailController @Inject()(orderDetailRepo: OrderDetailRepository, orderRepo: OrderRepository, productRepo: ProductRepository,
                                      cc: MessagesControllerComponents
                                )(implicit ec: ExecutionContext)
  extends MessagesAbstractController(cc) {
  val logger: Logger = Logger(this.getClass())

  val orderDetailForm: Form[CreateOrderDetailForm] = Form {
    mapping(
      "order_id" -> number,
      "product_id" -> number,
      "order_product_quantity" -> number
    )(CreateOrderDetailForm.apply)(CreateOrderDetailForm.unapply)
  }

  def get = Action.async { implicit request =>
    orderDetailRepo.list().map { order =>
      Ok(Json.toJson(order))
    }
  }

  def getById(id: String) = Action { Ok("product id " + id) }

  def addOrderDetailForm = Action.async { implicit request =>
    val orders = orderRepo.list()
    orders.map(order => Ok(views.html.order.add_order_detail(orderDetailForm,order)))
    /*
    .onComplete{
    case Success(categories) => Ok(views.html.index(productForm,categories))
    case Failure(t) => print("")
  }*/
  }

  def add = Action.async { implicit request =>
    // Bind the form first, then fold the result, passing a function to handle errors, and a function to handle succes.
    var a:Seq[Order] = Seq[Order]()
    val orders = orderRepo.list().onComplete{
      case Success(cat) => a = cat
      case Failure(_) => print("fail")
    }

    orderDetailForm.bindFromRequest.fold(
      // The error function. We return the index page with the error form, which will render the errors.
      // We also wrap the result in a successful future, since this action is synchronous, but we're required to return
      // a future because the person creation function returns a future.
      errorForm => {
        logger.info("error: " + errorForm)
        Future.successful(
          Ok(views.html.order.add_order_detail(errorForm,a))
        )
      },
      // There were no errors in the from, so create the person.
      orderDetail => {
        orderDetailRepo.create(orderDetail.orderId, orderDetail.productId, orderDetail.orderProductQuantity).map { _ =>
          // If successful, we simply redirect to the index page.
          Redirect(routes.OrdersDetailController.get).flashing("success" -> "product.created")
        }
      }
    )
  }

  def getById(id: Long) = Action.async { implicit  request =>
    orderDetailRepo.getById(id).map { order =>
      Ok(Json.toJson(order))
    }
  }


  def update(id: String) = Action { Ok("") }

}

case class CreateOrderDetailForm(orderId: Int, productId: Int, orderProductQuantity: Int)