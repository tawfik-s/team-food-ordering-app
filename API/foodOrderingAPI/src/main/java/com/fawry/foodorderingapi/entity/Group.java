package com.fawry.foodorderingapi.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    @ManyToOne
    private Restaurant restaurant;

    @ManyToMany
    private List<AppUser> Users;

    @OneToMany
    private List<SubOrder> orders;

}
