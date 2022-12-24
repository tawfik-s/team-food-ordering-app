package com.fawry.foodorderingapi.service.impl;

import com.fawry.foodorderingapi.entity.Food;
import com.fawry.foodorderingapi.entity.Order;
import com.fawry.foodorderingapi.entity.SubOrder;
import com.fawry.foodorderingapi.models.FoodItemDto;
import com.fawry.foodorderingapi.models.OrderDto;
import com.fawry.foodorderingapi.repository.FoodRepo;
import com.fawry.foodorderingapi.repository.SubOrderRepo;
import com.fawry.foodorderingapi.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class OrderService implements com.fawry.foodorderingapi.service.OrderService {

    @Autowired
   private SubOrderRepo orderRepo;

    @Autowired
    private FoodRepo foodRepo;
    @Autowired
   private FoodService foodService;

    @Transactional
    public Long createOrder(OrderDto orderDto) {
        Order order = new Order();
        order.setItems(new ArrayList<>());

        for(FoodItemDto foodItemDto : orderDto.getFood()){
            Food fooditem = foodService.getFoodById(foodItemDto.getItemId());
            order.getItems().add(new SubOrder(foodItemDto.getQuantity(),fooditem,order,foodItemDto.getComment()));
            foodRepo.saveAndFlush(fooditem);
        }

            orderRepo.saveAndFlush(order);
            return (order.getId());
    }


}
