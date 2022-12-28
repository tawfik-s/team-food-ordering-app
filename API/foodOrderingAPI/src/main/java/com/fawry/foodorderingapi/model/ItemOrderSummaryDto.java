package com.fawry.foodorderingapi.model;

import lombok.Data;

@Data
public class ItemOrderSummaryDto {

    private String item;

    private Long quantity;

    private float totalPrice;


    public ItemOrderSummaryDto(String item, Long quantity, float totalPrice) {
        this.item = item;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }
}