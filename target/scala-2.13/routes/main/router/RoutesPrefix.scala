// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/ryanraitz/Desktop/play-samples-play-scala-websocket-example-copy-2/conf/routes
// @DATE:Wed Sep 25 21:24:32 EDT 2019


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
