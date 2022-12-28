package com.fawry.foodorderingapi.entity;

import lombok.Getter;
import javax.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Optional;

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

    @ManyToOne
    private Food food;

    @ManyToOne
    private Order order;

    public SubOrder(int quantity, Food foodItem, Order order, String comment) {
        this.quantity = quantity;
        this.food = foodItem;
        this.order = order;
        this.comment = comment;

    }
}
