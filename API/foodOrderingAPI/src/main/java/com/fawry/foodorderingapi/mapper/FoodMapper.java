package com.fawry.foodorderingapi.mapper;

import com.fawry.foodorderingapi.entity.Food;
import com.fawry.foodorderingapi.model.FoodDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodMapper {

    FoodMapper INSTANCE = Mappers.getMapper(FoodMapper.class);

    FoodDto mapToFoodDto(Food food);

    Food mapToFood(FoodDto foodDto);
}
