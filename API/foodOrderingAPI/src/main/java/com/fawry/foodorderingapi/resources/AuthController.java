package com.fawry.foodorderingapi.resources;

import com.fawry.foodorderingapi.entity.AppUser;
import com.fawry.foodorderingapi.exception.RecordNotFoundException;
import com.fawry.foodorderingapi.mapper.NewUserDTOAndAppUserEntityMapper;
import com.fawry.foodorderingapi.model.LoginCredentials;
import com.fawry.foodorderingapi.model.UsersDto;
import com.fawry.foodorderingapi.repository.AppUserRepo;
import com.fawry.foodorderingapi.security.JWTUtil;
import com.fawry.foodorderingapi.service.impl.UserServiceImpl;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AppUserRepo userRepo;
    @Autowired
    private JWTUtil jwtUtil;
    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserServiceImpl userService;

    private NewUserDTOAndAppUserEntityMapper userMapper = Mappers.getMapper(NewUserDTOAndAppUserEntityMapper.class);

    @PostMapping("/register")
    public Map<String, Object> registerHandler(@Valid @RequestBody UsersDto newUser) {

        AppUser persist = userRepo.findByEmail(newUser.getEmail()).orElse(null);
        if (persist != null) {
            throw new RuntimeException("duplicated intern");
        }

        AppUser user = userMapper.userDtoModelToAppUserEntity(newUser);

        String encodedPass = passwordEncoder.encode(user.getPassword());

        user.setPassword(encodedPass);

        user = userRepo.save(user);

        String token = jwtUtil.generateToken(user.getEmail());

        return Collections.singletonMap("jwt-token", token);
    }

    @PostMapping("/login")
    public Map<String, Object> loginHandler(@Valid @RequestBody LoginCredentials body) {
        try {

            UsernamePasswordAuthenticationToken authInputToken = new UsernamePasswordAuthenticationToken(
                    body.getEmail(), body.getPassword());

            authManager.authenticate(authInputToken);

            String token = jwtUtil.generateToken(body.getEmail());

            return Collections.singletonMap("jwt-token", token);
        } catch (AuthenticationException authExc) {
            throw new RuntimeException("Invalid Login Credentials");
        }
    }


}
