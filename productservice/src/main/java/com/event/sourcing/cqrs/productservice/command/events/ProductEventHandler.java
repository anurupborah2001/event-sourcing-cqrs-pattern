package com.event.sourcing.cqrs.productservice.command.events;

import com.event.sourcing.cqrs.productservice.entity.Product;
import com.event.sourcing.cqrs.productservice.repository.ProductRepository;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.messaging.interceptors.ExceptionHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ProcessingGroup("product")
public class ProductEventHandler {

    @Autowired
    private ProductRepository productRepository;

    @EventHandler
    public void onEventHandler(ProductCreateEvent productCreateEvent) throws Exception {
        Product product = new Product();
        BeanUtils.copyProperties(productCreateEvent,product);
        productRepository.save(product);
        //When Exception is thrown than the records are not inserted. the record insertion is rollback
       // throw new Exception("ERROR HAPPENED");
    }

    @ExceptionHandler
    public void handle(Exception exception) throws Exception {
        throw exception;
    }
}
