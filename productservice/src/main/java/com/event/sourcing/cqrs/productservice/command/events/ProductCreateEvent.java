package com.event.sourcing.cqrs.productservice.command.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductCreateEvent {
    private String productId;
    private String name;
    private BigDecimal price;
    private Integer quantity;
}
