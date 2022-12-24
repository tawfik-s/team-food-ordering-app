package com.fawry.foodorderingapi.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodItemDto {

    private Long itemId;

    private int quantity ;

    private String comment ;

}
