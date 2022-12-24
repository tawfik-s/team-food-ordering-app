package com.fawry.foodorderingapi.entity;


import javax.persistence.*;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String Phone;

    @OneToMany
    private List<Food> foods;

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Phone='" + Phone + '\'' +
                '}';
    }
}
