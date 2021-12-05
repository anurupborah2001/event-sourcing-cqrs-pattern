package com.event.sourcing.cqrs.productservice;

import com.event.sourcing.cqrs.productservice.command.exceptions.ProductServiceEventsErrorHandler;
import org.axonframework.config.EventProcessingConfigurer;
import org.axonframework.eventhandling.ErrorHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductserviceApplication.class, args);
	}

	@Autowired
	public void configure(EventProcessingConfigurer configurer) {
		configurer.registerListenerInvocationErrorHandler(
				"product",
				configuration -> new ProductServiceEventsErrorHandler()
		);
	}
}
