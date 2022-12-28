package com.fawry.foodorderingapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import javax.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class SubOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int quantity;

    private String comment;

    private float subOrderPrice;

    @ManyToOne
    private Food food;

    @JsonIgnore
    @ManyToOne
    private Order order;

    public SubOrder(int quantity, Food foodItem, Order order, String comment, float subOrderPrice) {
        this.quantity = quantity;
        this.food = foodItem;
        this.order = order;
        this.comment = comment;
        this.subOrderPrice = subOrderPrice;

    }
}
