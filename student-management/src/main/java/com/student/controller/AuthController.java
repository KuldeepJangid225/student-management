
package com.student.controller;


import com.student.Enum.Role;
import com.student.entity.User;
import com.student.repository.UserRepository;
import com.student.security.JwtUtil;

import  com.student.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private UserRepository repo;

    @Autowired
    private JwtUtil jwtUtil;
//
//    @PostMapping("/register")
//    public String register(@RequestBody User user) {
//        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
//        repo.save(user);
//        return "User registered";
//    }
@PostMapping("/register")
public String register(@RequestBody User user) {

    user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

    // 🔥 ADD THESE LINES
    if (user.getRole() == null) {
        user.setRole(Role.USER);
    }

    user.setActive(true); // ⭐ MOST IMPORTANT

    repo.save(user);

    return "User registered";
}
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User dbUser = repo.findByEmail(user.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!new BCryptPasswordEncoder().matches(user.getPassword(), dbUser.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return jwtUtil.generateToken(user.getEmail());
    }
}