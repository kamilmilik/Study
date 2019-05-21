// @GENERATOR:play-routes-compiler
// @SOURCE:D:/kamil/pobraneZChrome/temp/git_repo/e-business/play-project/ecommerce_play_slick/conf/routes
// @DATE:Tue May 28 18:36:43 CEST 2019

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReversePersonController PersonController = new controllers.ReversePersonController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseCategoriesController CategoriesController = new controllers.ReverseCategoriesController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseOrdersDetailController OrdersDetailController = new controllers.ReverseOrdersDetailController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseUsersController UsersController = new controllers.ReverseUsersController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseOrdersController OrdersController = new controllers.ReverseOrdersController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseProductsController ProductsController = new controllers.ReverseProductsController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReversePersonController PersonController = new controllers.javascript.ReversePersonController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseCategoriesController CategoriesController = new controllers.javascript.ReverseCategoriesController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseOrdersDetailController OrdersDetailController = new controllers.javascript.ReverseOrdersDetailController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseUsersController UsersController = new controllers.javascript.ReverseUsersController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseOrdersController OrdersController = new controllers.javascript.ReverseOrdersController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseProductsController ProductsController = new controllers.javascript.ReverseProductsController(RoutesPrefix.byNamePrefix());
  }

}
