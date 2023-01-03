package com.fawry.foodorderingapi.service.impl;

import com.fawry.foodorderingapi.entity.AppUser;
import com.fawry.foodorderingapi.exception.RecordNotFoundException;
import com.fawry.foodorderingapi.mapper.NewUserDTOAndAppUserEntityMapper;
import com.fawry.foodorderingapi.model.LoginCredentials;
import com.fawry.foodorderingapi.model.UsersDto;
import com.fawry.foodorderingapi.repository.AppUserRepo;
import com.fawry.foodorderingapi.security.JWTUtil;
import com.fawry.foodorderingapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private AppUserRepo userRepo;
    @Autowired
    private JWTUtil jwtUtil;
    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private NewUserDTOAndAppUserEntityMapper newUser;

    @Override
    public UsersDto createUser(UsersDto usersDto) {
        AppUser user = newUser.toEntity(usersDto);
        userRepo.save(user);
        return usersDto;
    }

    @Override
    public Map<String, Object> registerUser(UsersDto usersDto) {
        AppUser persist = userRepo.findByEmail(usersDto.getEmail()).orElse(null);
        if (persist != null) {
            throw new RuntimeException("duplicated intern");
        }

        AppUser user = newUser.toEntity(usersDto);

        String encodedPass = passwordEncoder.encode(user.getPassword());

        user.setPassword(encodedPass);

        user = userRepo.save(user);

        String token = jwtUtil.generateToken(user.getEmail());

        return Collections.singletonMap("jwt-token", token);
    }

    @Override
    public Map<String, Object> loginUser(LoginCredentials credentials) {
        try {

            UsernamePasswordAuthenticationToken authInputToken = new UsernamePasswordAuthenticationToken(
                    credentials.getEmail(), credentials.getPassword());

            authManager.authenticate(authInputToken);

            String token = jwtUtil.generateToken(credentials.getEmail());

            return Collections.singletonMap("jwt-token", token);
        } catch (AuthenticationException authExc) {
            throw new RuntimeException("Invalid Login Credentials");
        }
    }

    public AppUser getCurrentUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = auth.getName();

        return userRepo.findByEmail(currentUserName).orElseThrow(RecordNotFoundException::new);
    }
}
