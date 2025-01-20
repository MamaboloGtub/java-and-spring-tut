package com.mamabologtub.jwt_practice.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mamabologtub.jwt_practice.Entity.User;
import com.mamabologtub.jwt_practice.dto.LoginDto;
import com.mamabologtub.jwt_practice.dto.UserDto;
import com.mamabologtub.jwt_practice.dto.response.LoginResponse;
import com.mamabologtub.jwt_practice.services.UserService;

import lombok.AllArgsConstructor;
import lombok.experimental.var;

/**
 * @Author Tshepo M Mahudu on Jan 17, 2025.
 */

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestParam String name, @RequestParam String email,
            @RequestParam String password,
            @RequestParam(required = false) MultipartFile profilePhoto) throws IOException {
        UserDto registerUserDto = new UserDto(name, email, password, profilePhoto);
        User registeredUser = userService.registerUser(registerUserDto);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/signin")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginDto loginUserDto) {
        var loginResponse = userService.authenticate(loginUserDto);
        return ResponseEntity.ok(loginResponse);
    }

}
