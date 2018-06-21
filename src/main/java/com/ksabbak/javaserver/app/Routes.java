package com.ksabbak.javaserver.app;
import com.ksabbak.javaserver.app.controller.*;
import com.ksabbak.javaserver.router.Router;

public class Routes implements Routable {
    public Routes(Router router){
        router.addRoute("/", IndexController.class);
        router.addRoute("/tea", TeaController.class);
        router.addRoute("/coffee", CoffeeController.class);
        router.addRoute("/form", FormController.class);
        router.addRoute("/put-target", PutTargetController.class);
        router.addRoute("/method_options", MethodOptionsController.class);
        router.addRoute("/method_options2", MethodOptions2Controller.class);
        router.addRoute("/redirect", RedirectController.class);
        router.addRoute("/cat-form", CatFormController.class);
        router.addRoute("/cat-form/data", CatFormDataController.class);
    }

}