package com.student.controller;

import com.student.dto.UserFilterRequest;
import com.student.entity.User;
import com.student.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

    private final UserService userService;

    // ✅ SEARCH with filter + pagination
    @PostMapping("/search")
    public Page<User> getUsers(@RequestBody UserFilterRequest request) {
        return userService.getAllUsers(request);
    }

    // ✅ GET by ID
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getById(id);
    }

    // ✅ CREATE (POST)
    @PostMapping
    public User create(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }

    // ✅ UPDATE (PUT - full update)
    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @Valid @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    // ✅ PARTIAL UPDATE (PATCH)
    @PatchMapping("/{id}")
    public User patch(@PathVariable Long id, @RequestBody User user) {
        return userService.patchUser(id, user);
    }

    // ✅ DELETE (Soft delete)
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        userService.deleteUser(id);
        return "User soft deleted successfully";
    }
}