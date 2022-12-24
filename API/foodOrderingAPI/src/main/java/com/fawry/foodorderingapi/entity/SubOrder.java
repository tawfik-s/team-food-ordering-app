package com.fawry.foodorderingapi.entity;

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

    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public SubOrder(int quantity, Food fooditem, Order order, String comment) {
        this.quantity = quantity;
        this.food = fooditem;
        this.order = order;
        this.comment = comment;

    }
}
