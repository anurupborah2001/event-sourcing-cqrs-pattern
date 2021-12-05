package com.event.sourcing.cqrs.productservice.query.contoller;

import com.event.sourcing.cqrs.productservice.model.ProductModel;
import com.event.sourcing.cqrs.productservice.query.queries.GetProductsQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class GetProductController {

    private QueryGateway queryGateway;

    public GetProductController(QueryGateway queryGateway){
        this.queryGateway = queryGateway;
    }

    @GetMapping
    public List<ProductModel> getAllProducts(){
        GetProductsQuery getProductsQuery = new GetProductsQuery();
        List<ProductModel> productRestModels =
                queryGateway.query(getProductsQuery,
                                ResponseTypes.multipleInstancesOf(ProductModel.class))
                        .join();
        return productRestModels;
    }
}
