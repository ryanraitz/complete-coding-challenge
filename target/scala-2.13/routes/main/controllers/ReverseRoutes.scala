// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/ryanraitz/Desktop/play-samples-play-scala-websocket-example-copy-2/conf/routes
// @DATE:Wed Sep 25 21:24:32 EDT 2019

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:5
package controllers {

  // @LINE:5
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def ws(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ws")
    }
  
    // @LINE:5
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:10
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def at(file:String): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[String]].unbind("file", file))
    }
  
  }

  // @LINE:7
  class ReverseStockSentiment(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def get(symbol:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "sentiment/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("symbol", symbol)))
    }
  
  }


}
