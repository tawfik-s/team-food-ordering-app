package com.fawry.foodorderingapi.model;

import com.fawry.foodorderingapi.entity.Restaurant;
import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class FoodDto {

    private String name;
    @Min(value = 1, message = "Enter valid price")
    private double price;
    private String image;
    private Restaurant restaurant;
}
