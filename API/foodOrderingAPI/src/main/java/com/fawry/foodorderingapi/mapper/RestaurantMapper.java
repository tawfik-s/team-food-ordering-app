package com.fawry.foodorderingapi.mapper;

import com.fawry.foodorderingapi.entity.Restaurant;
import com.fawry.foodorderingapi.model.RestaurantDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {

    RestaurantDto toDto(Restaurant restaurant);
    Restaurant toEntity(RestaurantDto restaurantDto);
}
