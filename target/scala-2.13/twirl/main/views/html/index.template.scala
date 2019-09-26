
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

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[Request[_$1] forSome { 
   type _$1
},play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/()(implicit r: Request[_]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""<!DOCTYPE html>

<html>
<head>
    <title>Reactive Stock News Dashboard</title>
    <link rel='stylesheet' href='"""),_display_(/*7.35*/routes/*7.41*/.Assets.at("lib/bootstrap/css/bootstrap.min.css")),format.raw/*7.90*/("""'>
    <link rel="stylesheet" media="screen" href=""""),_display_(/*8.50*/routes/*8.56*/.Assets.at("stylesheets/main.css")),format.raw/*8.90*/("""">
    <link rel="shortcut icon" type="image/png" href=""""),_display_(/*9.55*/routes/*9.61*/.Assets.at("images/favicon.png")),format.raw/*9.93*/("""">
    <script type='text/javascript' src='"""),_display_(/*10.42*/routes/*10.48*/.Assets.at("lib/jquery/jquery.min.js")),format.raw/*10.86*/("""'></script>
    <script type='text/javascript' src='"""),_display_(/*11.42*/routes/*11.48*/.Assets.at("lib/flot/jquery.flot.js")),format.raw/*11.85*/("""'></script>
    <script type='text/javascript' src='"""),_display_(/*12.42*/routes/*12.48*/.Assets.at("javascripts/index.js")),format.raw/*12.82*/("""'></script>
</head>
<body data-ws-url=""""),_display_(/*14.21*/routes/*14.27*/.HomeController.ws.webSocketURL()),format.raw/*14.60*/("""">
    <div class="navbar navbar-dark bg-dark justify-content-between">
        <div class="navbar-inner">
            <div class="container">
                <h1 class="text-left">Real-Time Stock Display</h1>
                <form id="addsymbolform" class="navbar-form pull-right">
                    <input id="addsymboltext" type="text" class="span2" placeholder="Stock Symbol">
                    <button type="submit" class="btn">Add Stock</button>
                </form>
            </div>
        </div>
    </div>

    <div id="stocks" class="container">

    </div>
</body>
</html>
"""))
      }
    }
  }

  def render(r:Request[_$1] forSome { 
   type _$1
}): play.twirl.api.HtmlFormat.Appendable = apply()(r)

  def f:(() => (Request[_$1] forSome { 
   type _$1
}) => play.twirl.api.HtmlFormat.Appendable) = () => (r) => apply()(r)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2019-09-26T12:35:25.104162
                  SOURCE: /Users/ryanraitz/Desktop/play-samples-play-scala-websocket-example-copy-2/app/views/index.scala.html
                  HASH: af23dee4cd9c5e790bb0b3a8c684e042a5787015
                  MATRIX: 760->1|880->28|1020->142|1034->148|1103->197|1181->249|1195->255|1249->289|1332->346|1346->352|1398->384|1469->428|1484->434|1543->472|1623->525|1638->531|1696->568|1776->621|1791->627|1846->661|1913->701|1928->707|1982->740
                  LINES: 23->1|28->2|33->7|33->7|33->7|34->8|34->8|34->8|35->9|35->9|35->9|36->10|36->10|36->10|37->11|37->11|37->11|38->12|38->12|38->12|40->14|40->14|40->14
                  -- GENERATED --
              */
          