package com.fawry.foodorderingapi.model;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UsersDto {

    @Size(min = 2, max = 400, message = "The User Name is not valid")
    private String name;
    //    @Size(min = 11,max = 11,message = "The Phone is not valid")
    @NotNull(message = "Phone is not null")
    private String phone;

    //TODO ignore in json
    @Size(min = 6, max = 4000, message = "The Password is not valid")
    private String password;
}
