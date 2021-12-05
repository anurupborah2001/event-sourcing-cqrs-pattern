package com.event.sourcing.cqrs.productservice.query.projection;

import com.event.sourcing.cqrs.productservice.entity.Product;
import com.event.sourcing.cqrs.productservice.model.ProductModel;
import com.event.sourcing.cqrs.productservice.query.queries.GetProductsQuery;
import com.event.sourcing.cqrs.productservice.repository.ProductRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetProductProjection {
    @Autowired
    private ProductRepository productRepository;

    @QueryHandler
    public List<ProductModel> getAllProducts(GetProductsQuery getProductsQuery){
        List<Product> products = productRepository.findAll();
        List<ProductModel> productModels = products.stream().map(product
                -> ProductModel.builder()
                .name(product.getName())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                        .build())
                .collect(Collectors.toList());
        return productModels;
    }

}
