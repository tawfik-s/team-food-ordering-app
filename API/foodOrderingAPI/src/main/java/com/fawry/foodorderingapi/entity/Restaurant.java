package com.fawry.foodorderingapi.entity;


import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Restaurant implements Serializable {

    private static final long serialVersionUID = -6470166940553717471L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String Phone;

    @OneToMany
    private List<Food> foods;
}
