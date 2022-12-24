package com.fawry.foodorderingapi.entity;

import lombok.Getter;
import javax.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity(name = "orders")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

 //   private String subOrderNotes;

    @OneToMany(mappedBy = "order" , cascade = CascadeType.ALL)
    private List<SubOrder> items;
}
