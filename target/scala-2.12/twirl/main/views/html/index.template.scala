
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
import java.lang._
import java.util._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import play.data._
import play.core.j.PlayFormsMagicForJava._

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!DOCTYPE html>

"""),_display_(/*3.2*/routes/*3.8*/.Assets.at("an_asset")),format.raw/*3.30*/(""" """),format.raw/*3.31*/("""(message: String)

<html>
    <head>
        <title>Reactive Tweet Analyticst</title>
        <script type='text/javascript' src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
        <script type='text/javascript' src='"""),_display_(/*9.46*/routes/*9.52*/.Assets.at("javascripts/index.js")),format.raw/*9.86*/("""'></script>
    </head>
    <body data-ws-url=""""),_display_(/*11.25*/routes/*11.31*/.HomeController.ws.webSocketURL()),format.raw/*11.64*/("""">
        <h1>Reactive Tweet Analytics</h1>
        <div id="tweet"> </div>
    </body>
</html>

"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Fri Apr 13 00:58:52 EDT 2018
                  SOURCE: C:/Users/Saman Rasool/Desktop/Concordia/Courses/SOEN 6441 Advance Programming Practices/ReactiveTweets_1.15/app/views/index.scala.html
                  HASH: a2c819e79cb6bb3855c24358eddd7923ec3056c1
                  MATRIX: 1030->0|1075->20|1088->26|1130->48|1158->49|1420->285|1434->291|1488->325|1565->375|1580->381|1634->414
                  LINES: 33->1|35->3|35->3|35->3|35->3|41->9|41->9|41->9|43->11|43->11|43->11
                  -- GENERATED --
              */
          