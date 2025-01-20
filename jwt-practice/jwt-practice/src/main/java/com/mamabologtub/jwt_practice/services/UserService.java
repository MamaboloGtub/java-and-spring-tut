package com.mamabologtub.jwt_practice.services;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mamabologtub.jwt_practice.Entity.User;
import com.mamabologtub.jwt_practice.dto.LoginDto;
import com.mamabologtub.jwt_practice.dto.UserDto;
import com.mamabologtub.jwt_practice.dto.response.LoginResponse;
import com.mamabologtub.jwt_practice.repository.UserRepository;

import lombok.AllArgsConstructor;
import lombok.experimental.var;

/**
 * @Author Tshepo M Mahudu on Jan 17, 2025.
 */

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public User registerUser(UserDto userDto) throws IOException {
        User user = new User();
        user.setName(userDto.name());
        user.setPassword(passwordEncoder.encode(userDto.password()));
        user.setEmail(userDto.email());
        var uuid = UUID.randomUUID().toString();
        user.setId(uuid);
        user.setRoles(List.of("ROLE_USER"));
        return userRepository.save(user);
    }

    public LoginResponse authenticate(LoginDto input) {
        var authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(input.email(), input.password()));
        var user = (User) authentication.getPrincipal();
        String token = tokenService.generateToken(authentication);
        String profilePhotoUrl = user.getProfilePhoto();
        return new LoginResponse(token, user.getName(), user.getEmail(), profilePhotoUrl);
    }
}
