package com.fawry.foodorderingapi.model;

import com.fawry.foodorderingapi.entity.Order;
import lombok.Data;

import java.util.List;
@Data
public class UserOrderSummaryDto {

    private String username;

    private List<Order> orders;
}
