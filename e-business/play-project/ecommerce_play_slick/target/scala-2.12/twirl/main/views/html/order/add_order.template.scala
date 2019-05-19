
package views.html.order

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
/*1.2*/import app.models.User

object add_order extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[Form[CreateOrderForm],Seq[User],MessagesRequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(order: Form[CreateOrderForm], user: Seq[User])(implicit request: MessagesRequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*4.2*/import helper._


Seq[Any](format.raw/*2.90*/("""

"""),format.raw/*5.1*/("""
"""),_display_(/*6.2*/request/*6.9*/.flash.get("success").map/*6.34*/ { key =>_display_(Seq[Any](format.raw/*6.43*/("""
    """),_display_(/*7.6*/request/*7.13*/.messages(key)),format.raw/*7.27*/("""
""")))}),format.raw/*8.2*/("""

"""),_display_(/*10.2*/main("Shop add order")/*10.24*/ {_display_(Seq[Any](format.raw/*10.26*/("""
    """),_display_(/*11.6*/form(routes.OrdersController.add())/*11.41*/ {_display_(Seq[Any](format.raw/*11.43*/("""
        """),_display_(/*12.10*/inputText(order("user_id"))),format.raw/*12.37*/("""
        """),_display_(/*13.10*/inputText(order("order_date"))),format.raw/*13.40*/("""
        """),_display_(/*14.10*/inputText(order("order_address"))),format.raw/*14.43*/("""
        """),_display_(/*15.10*/CSRF/*15.14*/.formField),format.raw/*15.24*/("""


"""),format.raw/*18.51*/("""
"""),format.raw/*19.35*/("""
"""),format.raw/*20.59*/("""
"""),format.raw/*21.14*/("""
"""),format.raw/*22.22*/("""

        """),format.raw/*24.9*/("""<div class="buttons">
            <input type="submit" value="add order"/>
        </div>
    """)))}),format.raw/*27.6*/("""
""")))}))
      }
    }
  }

  def render(order:Form[CreateOrderForm],user:Seq[User],request:MessagesRequestHeader): play.twirl.api.HtmlFormat.Appendable = apply(order,user)(request)

  def f:((Form[CreateOrderForm],Seq[User]) => (MessagesRequestHeader) => play.twirl.api.HtmlFormat.Appendable) = (order,user) => (request) => apply(order,user)(request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sun May 19 19:28:08 CEST 2019
                  SOURCE: D:/kamil/pobraneZChrome/temp/git_repo/e-business/play-project/ecommerce_play_slick/app/views/order/add_order.scala.html
                  HASH: 5e66a9abb421e3e13b58b4dd0d09f7fb7ae0bdcd
                  MATRIX: 438->1|816->26|977->119|1022->114|1052->136|1080->139|1094->146|1127->171|1173->180|1205->187|1220->194|1254->208|1286->211|1317->216|1348->238|1388->240|1421->247|1465->282|1505->284|1543->295|1591->322|1629->333|1680->363|1718->374|1772->407|1810->418|1823->422|1854->432|1888->488|1918->524|1948->584|1978->599|2008->622|2047->634|2175->732
                  LINES: 17->1|22->2|25->4|28->2|30->5|31->6|31->6|31->6|31->6|32->7|32->7|32->7|33->8|35->10|35->10|35->10|36->11|36->11|36->11|37->12|37->12|38->13|38->13|39->14|39->14|40->15|40->15|40->15|43->18|44->19|45->20|46->21|47->22|49->24|52->27
                  -- GENERATED --
              */
          