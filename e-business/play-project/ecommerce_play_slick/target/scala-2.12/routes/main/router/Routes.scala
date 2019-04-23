// @GENERATOR:play-routes-compiler
// @SOURCE:D:/kamil/Studia 4 rok/2 semestr/e-business/Study-master/e-business/play-project/ecommerce_play_slick/conf/routes
// @DATE:Tue Apr 30 16:25:13 CEST 2019

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  PersonController_0: controllers.PersonController,
  // @LINE:11
  Assets_5: controllers.Assets,
  // @LINE:14
  ProductsController_1: controllers.ProductsController,
  // @LINE:20
  OrdersController_4: controllers.OrdersController,
  // @LINE:26
  CategoriesController_3: controllers.CategoriesController,
  // @LINE:32
  UsersController_2: controllers.UsersController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    PersonController_0: controllers.PersonController,
    // @LINE:11
    Assets_5: controllers.Assets,
    // @LINE:14
    ProductsController_1: controllers.ProductsController,
    // @LINE:20
    OrdersController_4: controllers.OrdersController,
    // @LINE:26
    CategoriesController_3: controllers.CategoriesController,
    // @LINE:32
    UsersController_2: controllers.UsersController
  ) = this(errorHandler, PersonController_0, Assets_5, ProductsController_1, OrdersController_4, CategoriesController_3, UsersController_2, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, PersonController_0, Assets_5, ProductsController_1, OrdersController_4, CategoriesController_3, UsersController_2, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.PersonController.index"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """person""", """controllers.PersonController.addPerson"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """persons""", """controllers.PersonController.getPersons"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """products""", """controllers.ProductsController.get"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """add_product""", """controllers.ProductsController.addProductForm"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """products""", """controllers.ProductsController.add"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """products/""" + "$" + """id<[^/]+>""", """controllers.ProductsController.getById(id:String)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """products/""" + "$" + """id<[^/]+>""", """controllers.ProductsController.update(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """add_order""", """controllers.OrdersController.addOrderForm"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """orders""", """controllers.OrdersController.get"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """orders""", """controllers.OrdersController.add"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """orders/""" + "$" + """id<[^/]+>""", """controllers.OrdersController.getById(id:String)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """orders/""" + "$" + """id<[^/]+>""", """controllers.OrdersController.update(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """add_category""", """controllers.CategoriesController.addCategoryForm"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """categories""", """controllers.CategoriesController.get"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """categories""", """controllers.CategoriesController.add"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """categories/""" + "$" + """id<[^/]+>""", """controllers.CategoriesController.getById(id:String)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """categories/""" + "$" + """id<[^/]+>""", """controllers.CategoriesController.update(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """registration""", """controllers.UsersController.registration"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """controllers.UsersController.login"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users""", """controllers.UsersController.add"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users""", """controllers.UsersController.getUsers"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users/""" + "$" + """id<[^/]+>""", """controllers.UsersController.getById(id:String)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users/""" + "$" + """id<[^/]+>""", """controllers.UsersController.update(id:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_PersonController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_PersonController_index0_invoker = createInvoker(
    PersonController_0.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PersonController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ Home page""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_PersonController_addPerson1_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("person")))
  )
  private[this] lazy val controllers_PersonController_addPerson1_invoker = createInvoker(
    PersonController_0.addPerson,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PersonController",
      "addPerson",
      Nil,
      "POST",
      this.prefix + """person""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_PersonController_getPersons2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("persons")))
  )
  private[this] lazy val controllers_PersonController_getPersons2_invoker = createInvoker(
    PersonController_0.getPersons,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PersonController",
      "getPersons",
      Nil,
      "GET",
      this.prefix + """persons""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_Assets_versioned3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned3_invoker = createInvoker(
    Assets_5.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_ProductsController_get4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("products")))
  )
  private[this] lazy val controllers_ProductsController_get4_invoker = createInvoker(
    ProductsController_1.get,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProductsController",
      "get",
      Nil,
      "GET",
      this.prefix + """products""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_ProductsController_addProductForm5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("add_product")))
  )
  private[this] lazy val controllers_ProductsController_addProductForm5_invoker = createInvoker(
    ProductsController_1.addProductForm,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProductsController",
      "addProductForm",
      Nil,
      "GET",
      this.prefix + """add_product""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_ProductsController_add6_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("products")))
  )
  private[this] lazy val controllers_ProductsController_add6_invoker = createInvoker(
    ProductsController_1.add,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProductsController",
      "add",
      Nil,
      "POST",
      this.prefix + """products""",
      """""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_ProductsController_getById7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("products/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ProductsController_getById7_invoker = createInvoker(
    ProductsController_1.getById(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProductsController",
      "getById",
      Seq(classOf[String]),
      "GET",
      this.prefix + """products/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_ProductsController_update8_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("products/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ProductsController_update8_invoker = createInvoker(
    ProductsController_1.update(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProductsController",
      "update",
      Seq(classOf[String]),
      "PUT",
      this.prefix + """products/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:20
  private[this] lazy val controllers_OrdersController_addOrderForm9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("add_order")))
  )
  private[this] lazy val controllers_OrdersController_addOrderForm9_invoker = createInvoker(
    OrdersController_4.addOrderForm,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OrdersController",
      "addOrderForm",
      Nil,
      "GET",
      this.prefix + """add_order""",
      """""",
      Seq()
    )
  )

  // @LINE:21
  private[this] lazy val controllers_OrdersController_get10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("orders")))
  )
  private[this] lazy val controllers_OrdersController_get10_invoker = createInvoker(
    OrdersController_4.get,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OrdersController",
      "get",
      Nil,
      "GET",
      this.prefix + """orders""",
      """""",
      Seq()
    )
  )

  // @LINE:22
  private[this] lazy val controllers_OrdersController_add11_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("orders")))
  )
  private[this] lazy val controllers_OrdersController_add11_invoker = createInvoker(
    OrdersController_4.add,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OrdersController",
      "add",
      Nil,
      "POST",
      this.prefix + """orders""",
      """""",
      Seq()
    )
  )

  // @LINE:23
  private[this] lazy val controllers_OrdersController_getById12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("orders/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_OrdersController_getById12_invoker = createInvoker(
    OrdersController_4.getById(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OrdersController",
      "getById",
      Seq(classOf[String]),
      "GET",
      this.prefix + """orders/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:24
  private[this] lazy val controllers_OrdersController_update13_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("orders/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_OrdersController_update13_invoker = createInvoker(
    OrdersController_4.update(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OrdersController",
      "update",
      Seq(classOf[String]),
      "PUT",
      this.prefix + """orders/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:26
  private[this] lazy val controllers_CategoriesController_addCategoryForm14_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("add_category")))
  )
  private[this] lazy val controllers_CategoriesController_addCategoryForm14_invoker = createInvoker(
    CategoriesController_3.addCategoryForm,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CategoriesController",
      "addCategoryForm",
      Nil,
      "GET",
      this.prefix + """add_category""",
      """""",
      Seq()
    )
  )

  // @LINE:27
  private[this] lazy val controllers_CategoriesController_get15_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("categories")))
  )
  private[this] lazy val controllers_CategoriesController_get15_invoker = createInvoker(
    CategoriesController_3.get,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CategoriesController",
      "get",
      Nil,
      "GET",
      this.prefix + """categories""",
      """""",
      Seq()
    )
  )

  // @LINE:28
  private[this] lazy val controllers_CategoriesController_add16_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("categories")))
  )
  private[this] lazy val controllers_CategoriesController_add16_invoker = createInvoker(
    CategoriesController_3.add,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CategoriesController",
      "add",
      Nil,
      "POST",
      this.prefix + """categories""",
      """""",
      Seq()
    )
  )

  // @LINE:29
  private[this] lazy val controllers_CategoriesController_getById17_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("categories/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CategoriesController_getById17_invoker = createInvoker(
    CategoriesController_3.getById(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CategoriesController",
      "getById",
      Seq(classOf[String]),
      "GET",
      this.prefix + """categories/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:30
  private[this] lazy val controllers_CategoriesController_update18_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("categories/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CategoriesController_update18_invoker = createInvoker(
    CategoriesController_3.update(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CategoriesController",
      "update",
      Seq(classOf[String]),
      "PUT",
      this.prefix + """categories/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:32
  private[this] lazy val controllers_UsersController_registration19_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("registration")))
  )
  private[this] lazy val controllers_UsersController_registration19_invoker = createInvoker(
    UsersController_2.registration,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UsersController",
      "registration",
      Nil,
      "GET",
      this.prefix + """registration""",
      """""",
      Seq()
    )
  )

  // @LINE:33
  private[this] lazy val controllers_UsersController_login20_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_UsersController_login20_invoker = createInvoker(
    UsersController_2.login,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UsersController",
      "login",
      Nil,
      "GET",
      this.prefix + """login""",
      """""",
      Seq()
    )
  )

  // @LINE:34
  private[this] lazy val controllers_UsersController_add21_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users")))
  )
  private[this] lazy val controllers_UsersController_add21_invoker = createInvoker(
    UsersController_2.add,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UsersController",
      "add",
      Nil,
      "POST",
      this.prefix + """users""",
      """""",
      Seq()
    )
  )

  // @LINE:35
  private[this] lazy val controllers_UsersController_getUsers22_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users")))
  )
  private[this] lazy val controllers_UsersController_getUsers22_invoker = createInvoker(
    UsersController_2.getUsers,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UsersController",
      "getUsers",
      Nil,
      "GET",
      this.prefix + """users""",
      """""",
      Seq()
    )
  )

  // @LINE:36
  private[this] lazy val controllers_UsersController_getById23_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UsersController_getById23_invoker = createInvoker(
    UsersController_2.getById(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UsersController",
      "getById",
      Seq(classOf[String]),
      "GET",
      this.prefix + """users/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:37
  private[this] lazy val controllers_UsersController_update24_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UsersController_update24_invoker = createInvoker(
    UsersController_2.update(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UsersController",
      "update",
      Seq(classOf[String]),
      "PUT",
      this.prefix + """users/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_PersonController_index0_route(params@_) =>
      call { 
        controllers_PersonController_index0_invoker.call(PersonController_0.index)
      }
  
    // @LINE:7
    case controllers_PersonController_addPerson1_route(params@_) =>
      call { 
        controllers_PersonController_addPerson1_invoker.call(PersonController_0.addPerson)
      }
  
    // @LINE:8
    case controllers_PersonController_getPersons2_route(params@_) =>
      call { 
        controllers_PersonController_getPersons2_invoker.call(PersonController_0.getPersons)
      }
  
    // @LINE:11
    case controllers_Assets_versioned3_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned3_invoker.call(Assets_5.versioned(path, file))
      }
  
    // @LINE:14
    case controllers_ProductsController_get4_route(params@_) =>
      call { 
        controllers_ProductsController_get4_invoker.call(ProductsController_1.get)
      }
  
    // @LINE:15
    case controllers_ProductsController_addProductForm5_route(params@_) =>
      call { 
        controllers_ProductsController_addProductForm5_invoker.call(ProductsController_1.addProductForm)
      }
  
    // @LINE:16
    case controllers_ProductsController_add6_route(params@_) =>
      call { 
        controllers_ProductsController_add6_invoker.call(ProductsController_1.add)
      }
  
    // @LINE:17
    case controllers_ProductsController_getById7_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_ProductsController_getById7_invoker.call(ProductsController_1.getById(id))
      }
  
    // @LINE:18
    case controllers_ProductsController_update8_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_ProductsController_update8_invoker.call(ProductsController_1.update(id))
      }
  
    // @LINE:20
    case controllers_OrdersController_addOrderForm9_route(params@_) =>
      call { 
        controllers_OrdersController_addOrderForm9_invoker.call(OrdersController_4.addOrderForm)
      }
  
    // @LINE:21
    case controllers_OrdersController_get10_route(params@_) =>
      call { 
        controllers_OrdersController_get10_invoker.call(OrdersController_4.get)
      }
  
    // @LINE:22
    case controllers_OrdersController_add11_route(params@_) =>
      call { 
        controllers_OrdersController_add11_invoker.call(OrdersController_4.add)
      }
  
    // @LINE:23
    case controllers_OrdersController_getById12_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_OrdersController_getById12_invoker.call(OrdersController_4.getById(id))
      }
  
    // @LINE:24
    case controllers_OrdersController_update13_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_OrdersController_update13_invoker.call(OrdersController_4.update(id))
      }
  
    // @LINE:26
    case controllers_CategoriesController_addCategoryForm14_route(params@_) =>
      call { 
        controllers_CategoriesController_addCategoryForm14_invoker.call(CategoriesController_3.addCategoryForm)
      }
  
    // @LINE:27
    case controllers_CategoriesController_get15_route(params@_) =>
      call { 
        controllers_CategoriesController_get15_invoker.call(CategoriesController_3.get)
      }
  
    // @LINE:28
    case controllers_CategoriesController_add16_route(params@_) =>
      call { 
        controllers_CategoriesController_add16_invoker.call(CategoriesController_3.add)
      }
  
    // @LINE:29
    case controllers_CategoriesController_getById17_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_CategoriesController_getById17_invoker.call(CategoriesController_3.getById(id))
      }
  
    // @LINE:30
    case controllers_CategoriesController_update18_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_CategoriesController_update18_invoker.call(CategoriesController_3.update(id))
      }
  
    // @LINE:32
    case controllers_UsersController_registration19_route(params@_) =>
      call { 
        controllers_UsersController_registration19_invoker.call(UsersController_2.registration)
      }
  
    // @LINE:33
    case controllers_UsersController_login20_route(params@_) =>
      call { 
        controllers_UsersController_login20_invoker.call(UsersController_2.login)
      }
  
    // @LINE:34
    case controllers_UsersController_add21_route(params@_) =>
      call { 
        controllers_UsersController_add21_invoker.call(UsersController_2.add)
      }
  
    // @LINE:35
    case controllers_UsersController_getUsers22_route(params@_) =>
      call { 
        controllers_UsersController_getUsers22_invoker.call(UsersController_2.getUsers)
      }
  
    // @LINE:36
    case controllers_UsersController_getById23_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_UsersController_getById23_invoker.call(UsersController_2.getById(id))
      }
  
    // @LINE:37
    case controllers_UsersController_update24_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_UsersController_update24_invoker.call(UsersController_2.update(id))
      }
  }
}
