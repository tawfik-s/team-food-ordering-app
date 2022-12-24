package com.fawry.foodorderingapi.mapper;


import com.fawry.foodorderingapi.entity.Food;
import com.fawry.foodorderingapi.models.FoodCreationDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodMapper {

    FoodMapper INSTANCE = Mappers.getMapper(FoodMapper.class);
    FoodCreationDto mapToDto (Food t);

    Food mapToEntity(FoodCreationDto dto);
}
