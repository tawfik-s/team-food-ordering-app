package com.fawry.foodorderingapi.model;

import com.fawry.foodorderingapi.entity.Food;
import lombok.Data;

import java.util.List;

@Data
public class RestaurantDto {
    private Long id;
    private String name;
    private String Phone;
    private List<Food> foods;
}
