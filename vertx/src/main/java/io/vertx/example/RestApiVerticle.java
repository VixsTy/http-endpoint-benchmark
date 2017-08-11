package io.vertx.example;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.CorsHandler;

public class RestApiVerticle extends AbstractVerticle {

    private static final Logger logger = LoggerFactory.getLogger(RestApiVerticle.class);

    @Override
    public void start() throws Exception {
        super.start();

        logger.info("Start RestApiVerticle with config " + config().encodePrettily());

        Router router = Router.router(vertx);

        router.route().handler(CorsHandler.create("*")
                .allowedMethod(HttpMethod.GET)
                .allowedMethod(HttpMethod.POST)
                .allowedMethod(HttpMethod.OPTIONS)
//                .allowCredentials(true)
                .allowedHeader("Access-Control-Allow-Method")
                .allowedHeader("Access-Control-Allow-Origin")
                .allowedHeader("Access-Control-Allow-Headers")
                .allowedHeader("Content-Type"));

        router.route().handler(BodyHandler.create());

        router.get("/").handler(routingContext -> {
            routingContext.response().end("Hello World!");
        });

        Integer port = 8080;
        vertx.createHttpServer().requestHandler(router::accept).listen(port);
        logger.info("Http Server started on port " + port);
    }

}
