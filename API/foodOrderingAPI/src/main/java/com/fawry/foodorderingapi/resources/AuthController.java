package com.fawry.foodorderingapi.resources;

import com.fawry.foodorderingapi.model.LoginCredentials;
import com.fawry.foodorderingapi.model.UsersDto;
import com.fawry.foodorderingapi.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("auth")
@Slf4j
@Validated
public class AuthController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("register")
    public Map<String, Object> registerHandler(@Valid @RequestBody UsersDto usersDto) {
        log.info("register new user to database ");
        return userService.registerUser(usersDto);
    }

    @PostMapping("login")
    public Map<String, Object> loginHandler(@Valid @RequestBody LoginCredentials credentials) {
        log.info("logged in user with email={}", credentials.getEmail());
        return userService.loginUser(credentials);
    }

}
