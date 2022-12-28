package com.fawry.foodorderingapi.service;

import com.fawry.foodorderingapi.entity.Order;
import com.fawry.foodorderingapi.model.OrderDto;
import com.fawry.foodorderingapi.model.ItemOrderSummaryDto;
import com.fawry.foodorderingapi.model.UserOrderSummaryDto;

import java.util.List;

public interface OrderService {

    public Long createOrder(OrderDto orderDto , Long groupId);

    public void deleteOrder(Long id);

    public List<Order> getAllOrdersForCurrentUser();

    public Long createGroupOrder(Long groupId);

    public List<Order> getAllGroupOrders(Long groupId);

    public List<ItemOrderSummaryDto>getOrderSummaryPerItem(Long groupId);

    public List<UserOrderSummaryDto>getOrderSummaryPerUser(Long groupId);
}
