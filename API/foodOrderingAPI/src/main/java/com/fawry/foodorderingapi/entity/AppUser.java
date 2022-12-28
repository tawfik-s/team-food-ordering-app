package com.fawry.foodorderingapi.entity;

import lombok.*;

import javax.persistence.*;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String phone;

    private String password;

    private String email;

    @OneToMany(fetch = FetchType.LAZY)
    private List<AppGroup> OwnedGroups;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Order> Orders;
}
