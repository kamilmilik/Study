
package views.html.categories

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

object add_category extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[Form[CreateCategoryForm],MessagesRequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(category: Form[CreateCategoryForm])(implicit request: MessagesRequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*3.2*/import helper._


Seq[Any](format.raw/*1.79*/("""

"""),format.raw/*4.1*/("""
"""),_display_(/*5.2*/request/*5.9*/.flash.get("success").map/*5.34*/ { key =>_display_(Seq[Any](format.raw/*5.43*/("""
    """),_display_(/*6.6*/request/*6.13*/.messages(key)),format.raw/*6.27*/("""
""")))}),format.raw/*7.2*/("""

"""),_display_(/*9.2*/main("Shop category")/*9.23*/ {_display_(Seq[Any](format.raw/*9.25*/("""
    """),_display_(/*10.6*/form(routes.CategoriesController.add())/*10.45*/ {_display_(Seq[Any](format.raw/*10.47*/("""
        """),_display_(/*11.10*/inputText(category("name"))),format.raw/*11.37*/("""
        """),_display_(/*12.10*/CSRF/*12.14*/.formField),format.raw/*12.24*/("""

        """),format.raw/*14.9*/("""<div class="buttons">
            <input type="submit" value="Add category"/>
        </div>
    """)))}),format.raw/*17.6*/("""
""")))}))
      }
    }
  }

  def render(category:Form[CreateCategoryForm],request:MessagesRequestHeader): play.twirl.api.HtmlFormat.Appendable = apply(category)(request)

  def f:((Form[CreateCategoryForm]) => (MessagesRequestHeader) => play.twirl.api.HtmlFormat.Appendable) = (category) => (request) => apply(category)(request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Apr 30 15:25:42 CEST 2019
                  SOURCE: D:/kamil/Studia 4 rok/2 semestr/e-business/Study-master/e-business/play-project/ecommerce_play_slick/app/views/categories/add_category.scala.html
                  HASH: 376ba6bc9303cf0130bebec936203a27afce8a27
                  MATRIX: 787->1|937->83|982->78|1012->100|1040->103|1054->110|1087->135|1133->144|1165->151|1180->158|1214->172|1246->175|1276->180|1305->201|1344->203|1377->210|1425->249|1465->251|1503->262|1551->289|1589->300|1602->304|1633->314|1672->326|1803->427
                  LINES: 21->1|24->3|27->1|29->4|30->5|30->5|30->5|30->5|31->6|31->6|31->6|32->7|34->9|34->9|34->9|35->10|35->10|35->10|36->11|36->11|37->12|37->12|37->12|39->14|42->17
                  -- GENERATED --
              */
          