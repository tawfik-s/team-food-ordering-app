package com.fawry.foodorderingapi.resources;

import com.fawry.foodorderingapi.entity.Order;
import com.fawry.foodorderingapi.model.ItemOrderSummaryDto;
import com.fawry.foodorderingapi.model.OrderDto;
import com.fawry.foodorderingapi.model.UserOrderSummaryDto;
import com.fawry.foodorderingapi.service.impl.OrderServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/groups/{groupId}/orders")
@Slf4j
public class OrderController {
    @Autowired
   private OrderServiceImpl orderService;

    @PostMapping
    @Valid
    @ResponseStatus(HttpStatus.OK)
    public Long createUserOrder(@RequestBody OrderDto orderDto,@PathVariable Long groupId){
        log.info("create a new user order with groupId={}", groupId);
        return orderService.createOrder(orderDto,groupId);
    }


    @DeleteMapping("/cancel")
    @ResponseStatus(HttpStatus.OK)
    public void cancelOrder(@Valid @PathVariable Long groupId){
        log.info("Cancel Order with id={}", groupId);
        orderService.deleteOrder(groupId);
    }


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public Long createGroupOrder(@Valid @PathVariable Long groupId){
        log.info("Create a group order with id={}", groupId);
        return orderService.createGroupOrder(groupId);
    }


    @GetMapping("/view")
    @ResponseStatus(HttpStatus.OK)
    public List<Order>viewGroupOrder(@Valid @PathVariable Long groupId){
        log.info("viewing group order with id={}", groupId);
        return orderService.getAllGroupOrders(groupId);
    }


    @GetMapping("/items")
    @ResponseStatus(HttpStatus.OK)
    public List<ItemOrderSummaryDto>getOrderSummaryPerItem(@Valid @PathVariable Long groupId){
        log.info("Get order summary per item with id={}", groupId);
        return orderService.getOrderSummaryPerItem(groupId);
    }


    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<UserOrderSummaryDto>getOrderSummaryPerUser(@Valid @PathVariable Long groupId){
        log.info("Get order summary per user");
        return orderService.getOrderSummaryPerUser(groupId);
    }


}
