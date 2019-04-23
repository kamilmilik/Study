// @GENERATOR:play-routes-compiler
// @SOURCE:D:/kamil/Studia 4 rok/2 semestr/e-business/Study-master/e-business/play-project/ecommerce_play_slick/conf/routes
// @DATE:Tue Apr 30 16:25:13 CEST 2019


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
