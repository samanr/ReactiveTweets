// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Saman Rasool/Desktop/Concordia/Courses/SOEN 6441 Advance Programming Practices/ReactiveTweets_40026045/conf/routes
// @DATE:Fri Apr 13 15:24:44 EDT 2018

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseUserDetailsController UserDetailsController = new controllers.ReverseUserDetailsController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseHomeController HomeController = new controllers.ReverseHomeController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseUserDetailsController UserDetailsController = new controllers.javascript.ReverseUserDetailsController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseHomeController HomeController = new controllers.javascript.ReverseHomeController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
  }

}
