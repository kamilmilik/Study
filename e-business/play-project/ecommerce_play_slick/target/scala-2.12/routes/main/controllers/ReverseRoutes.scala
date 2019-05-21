// @GENERATOR:play-routes-compiler
// @SOURCE:D:/kamil/pobraneZChrome/temp/git_repo/e-business/play-project/ecommerce_play_slick/conf/routes
// @DATE:Tue May 28 18:36:43 CEST 2019

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers {

  // @LINE:6
  class ReversePersonController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def getPersons(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "persons")
    }
  
    // @LINE:6
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
    // @LINE:7
    def addPerson(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "person")
    }
  
  }

  // @LINE:11
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:32
  class ReverseCategoriesController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:32
    def addCategoryForm(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "add_category")
    }
  
    // @LINE:35
    def getById(id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "categories/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:34
    def add(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "categories")
    }
  
    // @LINE:33
    def get(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "categories")
    }
  
    // @LINE:36
    def update(id:String): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "categories/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
  }

  // @LINE:26
  class ReverseOrdersDetailController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:28
    def add(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "ordersDetail")
    }
  
    // @LINE:27
    def get(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ordersDetail")
    }
  
    // @LINE:29
    def getById(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ordersDetail/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:30
    def update(id:String): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "ordersDetail/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:26
    def addOrderDetailForm(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "add_order_detail")
    }
  
  }

  // @LINE:38
  class ReverseUsersController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:41
    def getUsers(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "users")
    }
  
    // @LINE:43
    def update(id:Long): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "users/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:38
    def registration(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "registration")
    }
  
    // @LINE:40
    def add(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "users")
    }
  
    // @LINE:42
    def getById(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "users/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:39
    def login(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "login")
    }
  
  }

  // @LINE:20
  class ReverseOrdersController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:22
    def add(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "orders")
    }
  
    // @LINE:21
    def get(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "orders")
    }
  
    // @LINE:23
    def getById(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "orders/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:24
    def update(id:String): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "orders/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:20
    def addOrderForm(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "add_order")
    }
  
  }

  // @LINE:14
  class ReverseProductsController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def add(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "products")
    }
  
    // @LINE:14
    def get(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "products")
    }
  
    // @LINE:17
    def getById(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "products/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:15
    def addProductForm(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "add_product")
    }
  
    // @LINE:18
    def update(id:String): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "products/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
  }


}
