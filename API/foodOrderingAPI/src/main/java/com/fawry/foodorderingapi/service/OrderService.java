package com.fawry.foodorderingapi.service;

import com.fawry.foodorderingapi.models.OrderDto;

public interface OrderService {

    public Long createOrder(OrderDto orderDto);
}
