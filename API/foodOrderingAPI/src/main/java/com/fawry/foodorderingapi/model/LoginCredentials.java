package com.fawry.foodorderingapi.model;


import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LoginCredentials {

    private String email;
    private String password;
}
