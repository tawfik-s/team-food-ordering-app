package com.fawry.foodorderingapi.mapper;

import com.fawry.foodorderingapi.entity.Food;
import com.fawry.foodorderingapi.model.FoodDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodMapper {
    FoodMapper INSTANCE = Mappers.getMapper(FoodMapper.class);
    FoodDto toDto(Food food);
    Food toEntity(FoodDto foodDto);
    void updateFoodFromDto(FoodDto foodDto, @MappingTarget Food food);
}
