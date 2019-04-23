package controllers

import app.models.Category
import javax.inject._
import models._
import play.api.Logger
import play.api.data.Form
import play.api.data.Forms._
import play.api.data.validation.Constraints._
import play.api.i18n._
import play.api.libs.json.Json
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}
import scala.concurrent.ExecutionContext

@Singleton
class ProductsController @Inject()(productsRepo: ProductRepository, categoryRepo: CategoryRepository,
                                   cc: MessagesControllerComponents
                                  )(implicit ec: ExecutionContext)
  extends MessagesAbstractController(cc) {
  val logger: Logger = Logger(this.getClass())

  val productForm: Form[CreateProductForm] = Form {
    mapping(
      "name" -> nonEmptyText,
      "description" -> nonEmptyText,
      "price" -> number,
      "unavailable" -> nonEmptyText,
      "category" -> number,
    )(CreateProductForm.apply)(CreateProductForm.unapply)
  }


  def get = Action.async { implicit request =>
    productsRepo.list().map { product =>
      Ok(Json.toJson(product))
    }
  }

  def getById(id: String) = Action { Ok("product id " + id) }

  def addProductForm = Action.async { implicit request =>
      val categories = categoryRepo.list()
      categories.map(cat => Ok(views.html.products.add_product(productForm,cat)))
      /*
      .onComplete{
      case Success(categories) => Ok(views.html.index(productForm,categories))
      case Failure(t) => print("")
    }*/
    }

  def add = Action.async { implicit request =>
    // Bind the form first, then fold the result, passing a function to handle errors, and a function to handle succes.
    var a:Seq[Category] = Seq[Category]()
    val categories = categoryRepo.list().onComplete{
      case Success(cat) => a = cat
      case Failure(_) => print("fail")
    }

    productForm.bindFromRequest.fold(
      // The error function. We return the index page with the error form, which will render the errors.
      // We also wrap the result in a successful future, since this action is synchronous, but we're required to return
      // a future because the person creation function returns a future.
      errorForm => {
        logger.info("error: " + errorForm)
        Future.successful(
          Ok(views.html.products.add_product(errorForm,a))
        )
      },
      // There were no errors in the from, so create the person.
      product => {
        productsRepo.create(product.name, product.description, product.price, product.unavailable, product.category).map { _ =>
          // If successful, we simply redirect to the index page.
          Redirect(routes.ProductsController.get).flashing("success" -> "product.created")
        }
      }
    )
  }

//
//  def getByCategory(id: Integer) = Action.async { implicit  request =>
//    productsRepo.getByCategory(id).map { products =>
//      Ok(Json.toJson(products))
//    }
//  }
//
//  def getByCategories = Action.async { implicit  request =>
//    val categories: List[Int] = List(1,2,3)
//
//    productsRepo.getByCategories(categories).map { products =>
//      Ok(Json.toJson(products))
//    }
//  }
//
//  def handlePost = Action.async { implicit request =>
//    val name = request.body.asJson.get("name").as[String]
//    val desc = request.body.asJson.get("description").as[String]
//
//    productsRepo.create(name,desc,1).map { product =>
//      Ok(Json.toJson(product))
//    }
//  }

  def update(id: String) = Action { Ok("") }

}

case class CreateProductForm(name: String, description: String, price: Int, unavailable: String, category: Int)
