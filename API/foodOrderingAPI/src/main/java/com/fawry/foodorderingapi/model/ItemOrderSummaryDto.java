package com.fawry.foodorderingapi.model;

import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class ItemOrderSummaryDto {

    private String item;
    @Min(value = 1, message = "Enter valid quantity")
    private Long quantity;

    private float totalPrice;


    public ItemOrderSummaryDto(String item, Long quantity, float totalPrice) {
        this.item = item;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }
}