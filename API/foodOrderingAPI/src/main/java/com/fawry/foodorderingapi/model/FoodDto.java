package com.fawry.foodorderingapi.model;

import com.fawry.foodorderingapi.entity.Restaurant;
import lombok.Data;

@Data
public class FoodDto {

    private Long id;
    private String name;
    private double price;
    private String image;
    private Restaurant restaurant;
}
