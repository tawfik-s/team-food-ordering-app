package com.fawry.foodorderingapi.service;

import com.fawry.foodorderingapi.model.OrderDto;

public interface OrderService {

    public Long createOrder(OrderDto orderDto);
}
