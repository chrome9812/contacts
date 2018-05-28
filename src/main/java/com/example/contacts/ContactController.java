package com.example.contacts;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ContactController extends AbstractVerticle {

    @Autowired
    ContactService contactService;

    @Override
    public void start(Future<Void> fut) throws Exception {
        Router router = Router.router(vertx);

        router.get("/api/contacts").handler(this::getAllContacts);
        router.get("/api/contacts/:name").handler(this::getContactByName);

        vertx.createHttpServer().requestHandler(router::accept).listen(
                        // Retrieve the port from the configuration,
                        // default to 8080.
                        config().getInteger("http.port", 8080),
                        result -> {
                            if (result.succeeded()) {
                                fut.complete();
                            } else {
                                fut.fail(result.cause());
                            }
                        }
                );



    }

    //Connects to couchbase. Save query is working but fetch query is not fetching all records by name
    private void getContactByName(RoutingContext routingContext) {
        String name = routingContext.request().getParam("name");
List<Contact> contacts = contactService.findByName(name);
        routingContext.response()
                .putHeader("content-type", "application/json; charset=utf-8")
                .end(Json.encodePrettily(contacts));
    }

    //In-memory
    private void getAllContacts(RoutingContext routingContext){

        List<Contact> contacts = Arrays.asList(new Contact("1","Shravan","9999999999", "GITAM","Vizag"),
                new Contact("2","Pavan","99999888889", "GITAM","Las Vegas"));
        routingContext.response()
                .putHeader("content-type", "application/json; charset=utf-8")
                .end(Json.encodePrettily(contacts));
    }
}
