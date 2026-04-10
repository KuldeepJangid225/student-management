
package com.student.controller;


import com.student.entity.User;
import com.student.security.JwtUtil;

import  com.student.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserService userService,
                          JwtUtil jwtUtil,
                          PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    // ✅ REGISTER
    @PostMapping("/register")
    public String register(@RequestBody User user) {
        userService.register(user);
        return "User registered";
    }

    // ✅ LOGIN (FINAL FIXED)
    @PostMapping("/login")
    public String login(@RequestBody User user) {

        User existingUser = userService.findByUsername(user.getUsername());

        if (passwordEncoder.matches(user.getPassword(), existingUser.getPassword())) {
            return jwtUtil.generateToken(existingUser.getUsername()); // ✅ TOKEN
        }

        throw new RuntimeException("Invalid username or password");
    }
}