package controllers

import javax.inject._
import models.CategoryRepository
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json.Json
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}

@Singleton
class CategoriesController @Inject()(categoryRepo: CategoryRepository,cc : MessagesControllerComponents)(implicit ec: ExecutionContext) extends MessagesAbstractController(cc) {

  val categoryForm: Form[CreateCategoryForm] = Form {
    mapping(
      "name" -> nonEmptyText
    )(CreateCategoryForm.apply)(CreateCategoryForm.unapply)
  }

  def get = Action.async{implicit request =>
    categoryRepo.list().map { category =>
      Ok(Json.toJson(category))
    }
  }

  def addCategoryForm = Action { implicit request =>
    Ok(views.html.categories.add_category(categoryForm))
  }

  def getById(id: Int) = Action.async { implicit  request =>
    categoryRepo.getById(id).map { order =>
      Ok(Json.toJson(order))
    }
  }

  def add = Action.async { implicit request =>
    categoryForm.bindFromRequest.fold(
      errorForm => {
        Future.successful(
          Ok(views.html.categories.add_category(errorForm))
        )
      },
      // There were no errors in the from, so create the person.
      category => {
        categoryRepo.create(category.name).map { _ =>
          // If successful, we simply redirect to the index page.
          Redirect(routes.CategoriesController.get).flashing("success" -> "category.created")
        }
      }
    )
  }

  def update(id: String) = Action { Ok("") }

}

case class CreateCategoryForm(name: String)
