package com.fawry.foodorderingapi.mapper;

import com.fawry.foodorderingapi.entity.Food;
import com.fawry.foodorderingapi.model.FoodDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface FoodMapper {

    FoodDto toDto(Food food);
    Food toEntity(FoodDto foodDto);
    void updateFoodFromDto(FoodDto foodDto, @MappingTarget Food food);
}
