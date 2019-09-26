// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/ryanraitz/Desktop/play-samples-play-scala-websocket-example-copy-2/conf/routes
// @DATE:Wed Sep 25 21:24:32 EDT 2019

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseHomeController HomeController = new controllers.ReverseHomeController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseStockSentiment StockSentiment = new controllers.ReverseStockSentiment(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseHomeController HomeController = new controllers.javascript.ReverseHomeController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseStockSentiment StockSentiment = new controllers.javascript.ReverseStockSentiment(RoutesPrefix.byNamePrefix());
  }

}
