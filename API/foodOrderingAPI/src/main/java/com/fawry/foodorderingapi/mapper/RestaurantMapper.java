package com.fawry.foodorderingapi.mapper;

import com.fawry.foodorderingapi.entity.Restaurant;
import com.fawry.foodorderingapi.model.RestaurantDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestaurantMapper {
    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);

    RestaurantDto toDto(Restaurant restaurant);
    Restaurant toEntity(RestaurantDto restaurantDto);
}
