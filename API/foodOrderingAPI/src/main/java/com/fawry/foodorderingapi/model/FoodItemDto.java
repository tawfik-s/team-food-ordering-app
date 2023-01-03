package com.fawry.foodorderingapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;

@Getter
@Setter
public class FoodItemDto {
    @Min(value = 1, message = "Enter valid Id")
    private Long itemId;
    @Min(value = 1, message = "Enter valid quantity")
    private int quantity ;

    private String comment ;

}
