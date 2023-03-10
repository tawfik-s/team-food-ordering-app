package com.fawry.foodorderingapi.mapper;

import com.fawry.foodorderingapi.entity.Order;
import com.fawry.foodorderingapi.model.OrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface OrderMapper {

    @Mapping(target = "food",source = "order.items")
    OrderDto mapToOrderDto (Order order);

    List<OrderDto> mapToOrdersDtos(List<Order> orders);

}
