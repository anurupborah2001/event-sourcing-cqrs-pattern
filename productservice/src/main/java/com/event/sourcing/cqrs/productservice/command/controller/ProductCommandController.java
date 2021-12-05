package com.event.sourcing.cqrs.productservice.command.controller;

import com.event.sourcing.cqrs.productservice.command.commands.CreateProductCommand;
import com.event.sourcing.cqrs.productservice.model.ProductModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductCommandController {
    private CommandGateway commandGateway;

    public ProductCommandController(CommandGateway commandGateway){
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public String createProduct(@RequestBody ProductModel productModel){
        CreateProductCommand createProductCommand
                = CreateProductCommand.builder()
                .productId(UUID.randomUUID().toString())
                .name(productModel.getName())
                .price(productModel.getPrice())
                .quantity(productModel.getQuantity())
                .build();
        return this.commandGateway.sendAndWait(createProductCommand);
    }
}
