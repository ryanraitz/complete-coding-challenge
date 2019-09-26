// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/ryanraitz/Desktop/play-samples-play-scala-websocket-example-copy-2/conf/routes
// @DATE:Wed Sep 25 21:24:32 EDT 2019

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:5
package controllers.javascript {

  // @LINE:5
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def ws: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.ws",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ws"})
        }
      """
    )
  
    // @LINE:5
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:10
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def at: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.at",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:7
  class ReverseStockSentiment(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def get: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.StockSentiment.get",
      """
        function(symbol0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "sentiment/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("symbol", symbol0))})
        }
      """
    )
  
  }


}
