package com.fawry.foodorderingapi.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodItemDto {

    private Long itemId;

    private int quantity ;

    private String comment ;

}
