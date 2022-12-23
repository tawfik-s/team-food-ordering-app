package com.fawry.foodorderingapi.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class AppGroup implements Serializable {

    private static final long serialVersionUID = -2034928754517110842L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    @ManyToOne
    private Restaurant restaurant;

    @ManyToMany
    private List<AppUser> Users;

    @ManyToMany
    private List<AppUser> UsersRequestToJoin;

    @OneToMany
    private List<Order> order;

}
