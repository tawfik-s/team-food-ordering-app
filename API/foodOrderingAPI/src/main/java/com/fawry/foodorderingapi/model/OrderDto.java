package com.fawry.foodorderingapi.model;

import com.fawry.foodorderingapi.model.FoodItemDto;
import lombok.Data;

import java.util.List;

@Data
public class OrderDto {

   private List<FoodItemDto>food;

}
