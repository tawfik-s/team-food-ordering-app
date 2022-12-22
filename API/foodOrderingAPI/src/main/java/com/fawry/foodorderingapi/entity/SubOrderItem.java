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
public class SubOrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int quantity;

    @OneToOne
    private Food food;
}
