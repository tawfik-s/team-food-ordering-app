package com.fawry.foodorderingapi.models;

import lombok.Data;

import java.util.List;

@Data
public class OrderDto {

   private List<FoodItemDto>food;

}
