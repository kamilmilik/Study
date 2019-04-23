
package views.html

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

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[Form[CreatePersonForm],MessagesRequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(person: Form[CreatePersonForm])(implicit request: MessagesRequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*3.2*/import helper._


Seq[Any](format.raw/*1.75*/("""

"""),format.raw/*4.1*/("""
"""),_display_(/*5.2*/request/*5.9*/.flash.get("success").map/*5.34*/ { key =>_display_(Seq[Any](format.raw/*5.43*/("""
   """),_display_(/*6.5*/request/*6.12*/.messages(key)),format.raw/*6.26*/("""
""")))}),format.raw/*7.2*/("""

"""),_display_(/*9.2*/main("Shop")/*9.14*/ {_display_(Seq[Any](format.raw/*9.16*/("""
  """),_display_(/*10.4*/form(routes.PersonController.addPerson())/*10.45*/ {_display_(Seq[Any](format.raw/*10.47*/("""
		"""),_display_(/*11.4*/inputText(person("name"))),format.raw/*11.29*/("""
		"""),_display_(/*12.4*/inputText(person("age"))),format.raw/*12.28*/("""
		"""),_display_(/*13.4*/CSRF/*13.8*/.formField),format.raw/*13.18*/("""

		"""),format.raw/*15.3*/("""<div class="buttons">
			<input type="submit" value="Add Person"/>
		</div>
	""")))}),format.raw/*18.3*/("""
""")))}),format.raw/*19.2*/("""
"""))
      }
    }
  }

  def render(person:Form[CreatePersonForm],request:MessagesRequestHeader): play.twirl.api.HtmlFormat.Appendable = apply(person)(request)

  def f:((Form[CreatePersonForm]) => (MessagesRequestHeader) => play.twirl.api.HtmlFormat.Appendable) = (person) => (request) => apply(person)(request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Apr 30 10:38:37 CEST 2019
                  SOURCE: D:/kamil/Studia 4 rok/2 semestr/e-business/Study-master/e-business/play-project/ecommerce_play_slick/app/views/index.scala.html
                  HASH: b0b89c78e1b1e12d0cde79e05734f6d4d39f38f3
                  MATRIX: 767->1|913->79|958->74|988->96|1016->99|1030->106|1063->131|1109->140|1140->146|1155->153|1189->167|1221->170|1251->175|1271->187|1310->189|1341->194|1391->235|1431->237|1462->242|1508->267|1539->272|1584->296|1615->301|1627->305|1658->315|1691->321|1802->402|1835->405
                  LINES: 21->1|24->3|27->1|29->4|30->5|30->5|30->5|30->5|31->6|31->6|31->6|32->7|34->9|34->9|34->9|35->10|35->10|35->10|36->11|36->11|37->12|37->12|38->13|38->13|38->13|40->15|43->18|44->19
                  -- GENERATED --
              */
          