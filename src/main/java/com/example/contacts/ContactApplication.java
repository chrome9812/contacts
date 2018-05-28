package com.example.contacts;

import io.vertx.core.Vertx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class ContactApplication {


	@Autowired
	ContactController contactController;

	public static void main(String[] args) {
		SpringApplication.run(ContactApplication.class, args);
	}

	@PostConstruct
	public void deployVerticle() {
		Vertx.vertx().deployVerticle(contactController);
	}
}
