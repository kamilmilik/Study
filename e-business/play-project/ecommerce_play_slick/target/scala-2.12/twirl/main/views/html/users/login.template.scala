
package views.html.users

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

object login extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[Form[LoginUserForm],MessagesRequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(user: Form[LoginUserForm])(implicit request: MessagesRequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*3.2*/import helper._


Seq[Any](format.raw/*1.70*/("""

"""),format.raw/*4.1*/("""
"""),_display_(/*5.2*/request/*5.9*/.flash.get("success").map/*5.34*/ { key =>_display_(Seq[Any](format.raw/*5.43*/("""
    """),_display_(/*6.6*/request/*6.13*/.messages(key)),format.raw/*6.27*/("""
""")))}),format.raw/*7.2*/("""

"""),_display_(/*9.2*/main("Shop login")/*9.20*/ {_display_(Seq[Any](format.raw/*9.22*/("""
    """),_display_(/*10.6*/form(routes.UsersController.getUsers())/*10.45*/ {_display_(Seq[Any](format.raw/*10.47*/("""
        """),_display_(/*11.10*/inputText(user("email"))),format.raw/*11.34*/("""
        """),_display_(/*12.10*/inputText(user("password"))),format.raw/*12.37*/("""
        """),_display_(/*13.10*/CSRF/*13.14*/.formField),format.raw/*13.24*/("""

        """),format.raw/*15.9*/("""<div class="buttons">
            <input type="submit" value="Login"/>
        </div>
    """)))}),format.raw/*18.6*/("""
""")))}))
      }
    }
  }

  def render(user:Form[LoginUserForm],request:MessagesRequestHeader): play.twirl.api.HtmlFormat.Appendable = apply(user)(request)

  def f:((Form[LoginUserForm]) => (MessagesRequestHeader) => play.twirl.api.HtmlFormat.Appendable) = (user) => (request) => apply(user)(request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sun May 19 15:03:51 CEST 2019
                  SOURCE: D:/kamil/pobraneZChrome/temp/git_repo/e-business/play-project/ecommerce_play_slick/app/views/users/login.scala.html
                  HASH: 62f3b499578a9c86938a8aab1e60b63dd0557b22
                  MATRIX: 770->1|911->74|956->69|986->91|1014->94|1028->101|1061->126|1107->135|1139->142|1154->149|1188->163|1220->166|1250->171|1276->189|1315->191|1348->198|1396->237|1436->239|1474->250|1519->274|1557->285|1605->312|1643->323|1656->327|1687->337|1726->349|1850->443
                  LINES: 21->1|24->3|27->1|29->4|30->5|30->5|30->5|30->5|31->6|31->6|31->6|32->7|34->9|34->9|34->9|35->10|35->10|35->10|36->11|36->11|37->12|37->12|38->13|38->13|38->13|40->15|43->18
                  -- GENERATED --
              */
          