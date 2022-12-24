package com.fawry.foodorderingapi.resources;

import com.fawry.foodorderingapi.models.OrderDto;
import com.fawry.foodorderingapi.service.impl.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService orderService;


    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Long createOrder(@RequestBody OrderDto orderDto){

        return orderService.createOrder(orderDto);
    }

}
