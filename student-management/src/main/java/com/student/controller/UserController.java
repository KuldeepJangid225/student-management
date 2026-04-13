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

    //CREATE
    @PostMapping
    public User create(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }

    // GET BY ID
    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    //GET ALL (Pagination + Filter)
    @PostMapping("/search")
    public Page<User> getAll(@RequestBody UserFilterRequest request) {
        return userService.getAllUsers(request);
    }

    //UPDATE (PUT - Full)
    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @Valid @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    // PATCH (Partial Update)
    @PatchMapping("/{id}")
    public User patch(@PathVariable Long id, @RequestBody User user) {
        return userService.patchUser(id, user);
    }

    // DELETE (Soft Delete)
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        userService.deleteUser(id);
        return "User deleted successfully";
    }
}