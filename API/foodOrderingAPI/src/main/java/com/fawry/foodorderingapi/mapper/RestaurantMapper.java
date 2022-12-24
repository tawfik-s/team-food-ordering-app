package com.fawry.foodorderingapi.mapper;

import com.fawry.foodorderingapi.entity.Restaurant;
import com.fawry.foodorderingapi.model.RestaurantDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestaurantMapper {

    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);

    RestaurantDto mapToRestaurantDto(Restaurant restaurant);
    Restaurant mapToRestaurant(RestaurantDto restaurantDto);
}
