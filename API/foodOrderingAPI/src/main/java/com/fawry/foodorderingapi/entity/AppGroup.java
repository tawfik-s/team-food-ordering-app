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
public class AppGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String anyOneCanJoinWithoutRequest;  

    private String groupIsFinished;

    @ManyToOne
    private Restaurant restaurant;

    @ManyToMany
    private List<AppUser> Users;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<AppUser> UsersRequestToJoin;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Order> order;

}
