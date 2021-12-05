package com.event.sourcing.cqrs.productservice.command.aggregate;

import com.event.sourcing.cqrs.productservice.command.commands.CreateProductCommand;
import com.event.sourcing.cqrs.productservice.command.events.ProductCreateEvent;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

//Command Handler
@Aggregate
public class ProductAggregate {

    @AggregateIdentifier
    private String productId;
    private String name;
    private BigDecimal price;
    private Integer quantity;

    //add to the event source
    @CommandHandler
   public ProductAggregate(CreateProductCommand createProductCommand){
        //Any validation can be done here
       ProductCreateEvent productCreateEvent = new ProductCreateEvent();
       BeanUtils.copyProperties(createProductCommand,productCreateEvent);
       AggregateLifecycle.apply(productCreateEvent);
   }

   @EventSourcingHandler
   public void onEventHandler(ProductCreateEvent productCreateEvent){
        this.productId = productCreateEvent.getProductId();
        this.name = productCreateEvent.getName();
        this.price = productCreateEvent.getPrice();
        this.quantity = productCreateEvent.getQuantity();
   }
}
