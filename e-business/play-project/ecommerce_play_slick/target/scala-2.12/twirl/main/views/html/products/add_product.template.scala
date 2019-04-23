
package views.html.products

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
/*1.2*/import app.models.Category

object add_product extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[Form[CreateProductForm],Seq[Category],MessagesRequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(product: Form[CreateProductForm], category: Seq[Category])(implicit request: MessagesRequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*4.2*/import helper._


Seq[Any](format.raw/*2.102*/("""

"""),format.raw/*5.1*/("""
"""),_display_(/*6.2*/request/*6.9*/.flash.get("success").map/*6.34*/ { key =>_display_(Seq[Any](format.raw/*6.43*/("""
    """),_display_(/*7.6*/request/*7.13*/.messages(key)),format.raw/*7.27*/("""
""")))}),format.raw/*8.2*/("""

"""),_display_(/*10.2*/main("Shop add product")/*10.26*/ {_display_(Seq[Any](format.raw/*10.28*/("""
    """),_display_(/*11.6*/form(routes.ProductsController.add())/*11.43*/ {_display_(Seq[Any](format.raw/*11.45*/("""
        """),_display_(/*12.10*/inputText(product("name"))),format.raw/*12.36*/("""
        """),_display_(/*13.10*/inputText(product("description"))),format.raw/*13.43*/("""
        """),_display_(/*14.10*/inputText(product("price"))),format.raw/*14.37*/("""
        """),_display_(/*15.10*/inputText(product("unavailable"))),format.raw/*15.43*/("""
        """),_display_(/*16.10*/inputText(product("category"))),format.raw/*16.40*/("""
        """),_display_(/*17.10*/CSRF/*17.14*/.formField),format.raw/*17.24*/("""


        """),format.raw/*20.9*/("""<select name="category" id="category">
        """),_display_(/*21.10*/for(cat <- category) yield /*21.30*/{_display_(Seq[Any](format.raw/*21.31*/("""
            """),format.raw/*22.13*/("""<option value=""""),_display_(/*22.29*/cat/*22.32*/.id),format.raw/*22.35*/("""">"""),_display_(/*22.38*/cat/*22.41*/.name),format.raw/*22.46*/("""</option>
        """)))}),format.raw/*23.10*/("""
        """),format.raw/*24.9*/("""</select>

        <div class="buttons">
            <input type="submit" value="add product"/>
        </div>
    """)))}),format.raw/*29.6*/("""
""")))}))
      }
    }
  }

  def render(product:Form[CreateProductForm],category:Seq[Category],request:MessagesRequestHeader): play.twirl.api.HtmlFormat.Appendable = apply(product,category)(request)

  def f:((Form[CreateProductForm],Seq[Category]) => (MessagesRequestHeader) => play.twirl.api.HtmlFormat.Appendable) = (product,category) => (request) => apply(product,category)(request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Apr 30 14:49:03 CEST 2019
                  SOURCE: D:/kamil/Studia 4 rok/2 semestr/e-business/Study-master/e-business/play-project/ecommerce_play_slick/app/views/products/add_product.scala.html
                  HASH: 49cc0d0c5085ad062aa64095db9f41bf6af2fe82
                  MATRIX: 441->1|831->30|1004->135|1050->130|1080->152|1108->155|1122->162|1155->187|1201->196|1233->203|1248->210|1282->224|1314->227|1345->232|1378->256|1418->258|1451->265|1497->302|1537->304|1575->315|1622->341|1660->352|1714->385|1752->396|1800->423|1838->434|1892->467|1930->478|1981->508|2019->519|2032->523|2063->533|2104->547|2180->596|2216->616|2255->617|2297->631|2340->647|2352->650|2376->653|2406->656|2418->659|2444->664|2495->684|2532->694|2683->815
                  LINES: 17->1|22->2|25->4|28->2|30->5|31->6|31->6|31->6|31->6|32->7|32->7|32->7|33->8|35->10|35->10|35->10|36->11|36->11|36->11|37->12|37->12|38->13|38->13|39->14|39->14|40->15|40->15|41->16|41->16|42->17|42->17|42->17|45->20|46->21|46->21|46->21|47->22|47->22|47->22|47->22|47->22|47->22|47->22|48->23|49->24|54->29
                  -- GENERATED --
              */
          