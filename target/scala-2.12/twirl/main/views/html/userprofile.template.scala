
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
/*1.2*/import models.UserDetails

object userprofile extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[UserDetails,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(user: UserDetails):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.21*/("""

"""),format.raw/*5.1*/("""<!DOCTYPE html>
<html lang="en" class="no-js">
    <head>
        <title>TweetAnalytics - Profile ("""),_display_(/*8.43*/user/*8.47*/.getScreenName()),format.raw/*8.63*/(""")</title>
        <link rel="shortcut icon" type="image/png" href=""""),_display_(/*9.59*/routes/*9.65*/.Assets.versioned("img/favicon.png")),format.raw/*9.101*/("""">
        <link rel="stylesheet" type="text/css" href=""""),_display_(/*10.55*/routes/*10.61*/.Assets.versioned("stylesheets/search.css")),format.raw/*10.104*/("""" />
        <script src=""""),_display_(/*11.23*/routes/*11.29*/.Assets.versioned("javascripts/jquery-3.3.1.min.js")),format.raw/*11.81*/(""""></script>
            <!--[if IE]>
  		<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
    </head>
    <body>
        <div >
            <h3>User Profile</h3>

            <p>User name: - """),_display_(/*20.30*/user/*20.34*/.getName()),format.raw/*20.44*/("""</p>

            """),_display_(/*22.14*/if(user.getScreenName()!= null)/*22.45*/ {_display_(Seq[Any](format.raw/*22.47*/("""
                """),format.raw/*23.17*/("""<a target="_blank" href="https://twitter.com/"""),_display_(/*23.63*/user/*23.67*/.getScreenName()),format.raw/*23.83*/("""">TwitterPage</a>
            """)))}),format.raw/*24.14*/("""
            """),_display_(/*25.14*/if(user.getUserBio()!= null)/*25.42*/ {_display_(Seq[Any](format.raw/*25.44*/("""
                """),format.raw/*26.17*/("""<p >Bio: """),_display_(/*26.27*/user/*26.31*/.getUserBio()),format.raw/*26.44*/("""</p>
            """)))}),format.raw/*27.14*/("""
            """),format.raw/*28.13*/("""<p >Followers: """),_display_(/*28.29*/user/*28.33*/.getFollowersCount()),format.raw/*28.53*/("""</p>

            <h3>Last 10 tweets: </h3>
            """),_display_(/*31.14*/for(tweet <- user.getLastTenTweets()) yield /*31.51*/ {_display_(Seq[Any](format.raw/*31.53*/("""
                """),format.raw/*32.17*/("""<p>* """),_display_(/*32.23*/tweet),format.raw/*32.28*/("""</p>
            """)))}),format.raw/*33.14*/("""
        """),format.raw/*34.9*/("""</div>
    </body>
</html>

"""))
      }
    }
  }

  def render(user:UserDetails): play.twirl.api.HtmlFormat.Appendable = apply(user)

  def f:((UserDetails) => play.twirl.api.HtmlFormat.Appendable) = (user) => apply(user)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Fri Apr 13 02:40:01 EDT 2018
                  SOURCE: C:/Users/Saman Rasool/Desktop/Concordia/Courses/SOEN 6441 Advance Programming Practices/ReactiveTweets_1.15/app/views/userprofile.scala.html
                  HASH: 51eff5e48b97873f421f3055a60f0d5e7dd6f5c9
                  MATRIX: 651->1|992->31|1106->50|1136->54|1265->157|1277->161|1313->177|1408->246|1422->252|1479->288|1564->346|1579->352|1644->395|1699->423|1714->429|1787->481|2056->723|2069->727|2100->737|2148->758|2188->789|2228->791|2274->809|2347->855|2360->859|2397->875|2460->907|2502->922|2539->950|2579->952|2625->970|2662->980|2675->984|2709->997|2759->1016|2801->1030|2844->1046|2857->1050|2898->1070|2985->1130|3038->1167|3078->1169|3124->1187|3157->1193|3183->1198|3233->1217|3270->1227
                  LINES: 24->1|29->3|34->3|36->5|39->8|39->8|39->8|40->9|40->9|40->9|41->10|41->10|41->10|42->11|42->11|42->11|51->20|51->20|51->20|53->22|53->22|53->22|54->23|54->23|54->23|54->23|55->24|56->25|56->25|56->25|57->26|57->26|57->26|57->26|58->27|59->28|59->28|59->28|59->28|62->31|62->31|62->31|63->32|63->32|63->32|64->33|65->34
                  -- GENERATED --
              */
          