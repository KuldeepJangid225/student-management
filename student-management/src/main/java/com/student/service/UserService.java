package com.student.service;

import com.student.dto.UserFilterRequest;
import com.student.entity.User;
import org.springframework.data.domain.Page;

public interface UserService {

    User createUser(User user);

    User getById(Long id);

    Page<User> getAllUsers(UserFilterRequest request);

    User updateUser(Long id, User user);

    User patchUser(Long id, User user);

    void deleteUser(Long id);

    User findByEmail(String email);
}