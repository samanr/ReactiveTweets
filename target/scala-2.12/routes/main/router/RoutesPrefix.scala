// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Saman Rasool/Desktop/Concordia/Courses/SOEN 6441 Advance Programming Practices/ReactiveTweets_40026045/conf/routes
// @DATE:Fri Apr 13 15:24:44 EDT 2018


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
