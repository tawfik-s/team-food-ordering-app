package com.fawry.foodorderingapi.model;


import lombok.*;

import javax.validation.constraints.Email;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LoginCredentials {

    @Email
    private String email;
    private String password;
}
