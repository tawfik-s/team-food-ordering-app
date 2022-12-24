package com.fawry.foodorderingapi.model;

import lombok.Data;

@Data
public class FoodDto {

    private Long id;
    private String name;
    private double price;
    private String image;
}
