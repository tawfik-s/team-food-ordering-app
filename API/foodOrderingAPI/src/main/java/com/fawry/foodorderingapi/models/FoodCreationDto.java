package com.fawry.foodorderingapi.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodCreationDto {

    private Long id;

    private String name;

    private float price;

    private String image;
}
