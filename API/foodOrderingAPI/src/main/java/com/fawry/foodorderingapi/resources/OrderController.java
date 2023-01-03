package com.fawry.foodorderingapi.resources;

import com.fawry.foodorderingapi.entity.Order;
import com.fawry.foodorderingapi.mapper.OrderMapper;
import com.fawry.foodorderingapi.model.OrderDto;
import com.fawry.foodorderingapi.model.ItemOrderSummaryDto;
import com.fawry.foodorderingapi.model.UserOrderSummaryDto;
import com.fawry.foodorderingapi.service.impl.OrderServiceImpl;
import com.fawry.foodorderingapi.service.impl.UserServiceImpl;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups/{groupId}/orders")
public class OrderController {
    @Autowired
   private OrderServiceImpl orderService;

    @Autowired
   private UserServiceImpl userService;


    private OrderMapper orderMapper = Mappers.getMapper(OrderMapper.class);



    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Long createUserOrder(@RequestBody OrderDto orderDto,@PathVariable Long groupId){

        return orderService.createOrder(orderDto,groupId);
    }


    @DeleteMapping("/cancel")
    @ResponseStatus(HttpStatus.OK)
    public void cancelOrder(@PathVariable Long id){

        orderService.deleteOrder(id);
    }


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public Long createGroupOrder(@PathVariable Long groupId){

        return orderService.createGroupOrder(groupId);
    }


    @GetMapping("/view")
    @ResponseStatus(HttpStatus.OK)
    public List<Order>viewGroupOrder(@PathVariable Long groupId){

        return orderService.getAllGroupOrders(groupId);
    }


    @GetMapping("/items")
    @ResponseStatus(HttpStatus.OK)
    public List<ItemOrderSummaryDto>getOrderSummaryPerItem(@PathVariable Long groupId){

        return orderService.getOrderSummaryPerItem(groupId);
    }


    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<UserOrderSummaryDto>getOrderSummaryPerUser(@PathVariable Long groupId){

        return orderService.getOrderSummaryPerUser(groupId);
    }


}
