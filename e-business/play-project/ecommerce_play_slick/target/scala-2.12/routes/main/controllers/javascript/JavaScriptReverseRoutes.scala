// @GENERATOR:play-routes-compiler
// @SOURCE:D:/kamil/pobraneZChrome/temp/git_repo/e-business/play-project/ecommerce_play_slick/conf/routes
// @DATE:Tue May 28 18:36:43 CEST 2019

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers.javascript {

  // @LINE:6
  class ReversePersonController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def getPersons: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PersonController.getPersons",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "persons"})
        }
      """
    )
  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PersonController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
    // @LINE:7
    def addPerson: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PersonController.addPerson",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "person"})
        }
      """
    )
  
  }

  // @LINE:11
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:32
  class ReverseCategoriesController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:32
    def addCategoryForm: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CategoriesController.addCategoryForm",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "add_category"})
        }
      """
    )
  
    // @LINE:35
    def getById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CategoriesController.getById",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "categories/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:34
    def add: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CategoriesController.add",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "categories"})
        }
      """
    )
  
    // @LINE:33
    def get: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CategoriesController.get",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "categories"})
        }
      """
    )
  
    // @LINE:36
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CategoriesController.update",
      """
        function(id0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "categories/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
  }

  // @LINE:26
  class ReverseOrdersDetailController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:28
    def add: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OrdersDetailController.add",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "ordersDetail"})
        }
      """
    )
  
    // @LINE:27
    def get: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OrdersDetailController.get",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ordersDetail"})
        }
      """
    )
  
    // @LINE:29
    def getById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OrdersDetailController.getById",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ordersDetail/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:30
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OrdersDetailController.update",
      """
        function(id0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "ordersDetail/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:26
    def addOrderDetailForm: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OrdersDetailController.addOrderDetailForm",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "add_order_detail"})
        }
      """
    )
  
  }

  // @LINE:38
  class ReverseUsersController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:41
    def getUsers: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UsersController.getUsers",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "users"})
        }
      """
    )
  
    // @LINE:43
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UsersController.update",
      """
        function(id0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "users/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:38
    def registration: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UsersController.registration",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "registration"})
        }
      """
    )
  
    // @LINE:40
    def add: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UsersController.add",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "users"})
        }
      """
    )
  
    // @LINE:42
    def getById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UsersController.getById",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "users/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:39
    def login: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UsersController.login",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
        }
      """
    )
  
  }

  // @LINE:20
  class ReverseOrdersController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:22
    def add: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OrdersController.add",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "orders"})
        }
      """
    )
  
    // @LINE:21
    def get: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OrdersController.get",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "orders"})
        }
      """
    )
  
    // @LINE:23
    def getById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OrdersController.getById",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "orders/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:24
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OrdersController.update",
      """
        function(id0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "orders/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:20
    def addOrderForm: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OrdersController.addOrderForm",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "add_order"})
        }
      """
    )
  
  }

  // @LINE:14
  class ReverseProductsController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def add: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ProductsController.add",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "products"})
        }
      """
    )
  
    // @LINE:14
    def get: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ProductsController.get",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "products"})
        }
      """
    )
  
    // @LINE:17
    def getById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ProductsController.getById",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "products/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:15
    def addProductForm: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ProductsController.addProductForm",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "add_product"})
        }
      """
    )
  
    // @LINE:18
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ProductsController.update",
      """
        function(id0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "products/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
  }


}
