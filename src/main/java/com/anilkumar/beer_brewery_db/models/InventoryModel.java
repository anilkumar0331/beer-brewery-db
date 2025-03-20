package com.anilkumar.beer_brewery_db.models;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InventoryModel {

    private Long beerId;
    private String nameOfBeer;
    private Integer numOfBeers;
    private BigDecimal beerCost;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
