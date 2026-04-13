package com.student.service;

import com.student.Enum.Role;
import com.student.dto.UserFilterRequest;
import com.student.entity.User;

import com.student.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // ✅ GET by ID
    @Override
    public User getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // ✅ GET by Email
    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // ✅ GET ALL with Pagination + Filter
    @Override
    public Page<User> getAllUsers(UserFilterRequest request) {

        Pageable pageable = PageRequest.of(
                request.getPage(),
                request.getSize(),
                Sort.by("createdAt").descending()
        );

        return userRepository.findAll(
                UserSpecification.filterUsers(
                        request.getName(),
                        request.getEmail(),
                        request.getRole(),
                        request.getActive()
                ),
                pageable
        );
    }

    // ✅ POST (Register/Create)
    @Override
    public User createUser(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        if (user.getRole() == null) {
            user.setRole(Role.USER);
        }

        user.setActive(true);

        return userRepository.save(user);
    }

    // ✅ PUT (Full Update)
    @Override
    public User updateUser(Long id, User updatedUser) {

        User existing = getById(id);

        existing.setName(updatedUser.getName());
        existing.setEmail(updatedUser.getEmail());
        existing.setRole(updatedUser.getRole());
        existing.setActive(updatedUser.getActive());

        if (updatedUser.getPassword() != null && !updatedUser.getPassword().isEmpty()) {
            existing.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
        }

        return userRepository.save(existing);
    }

    // ✅ PATCH (Partial Update)
    @Override
    public User patchUser(Long id, User updatedUser) {

        User existing = getById(id);

        if (updatedUser.getName() != null)
            existing.setName(updatedUser.getName());

        if (updatedUser.getEmail() != null)
            existing.setEmail(updatedUser.getEmail());

        if (updatedUser.getRole() != null)
            existing.setRole(updatedUser.getRole());

        if (updatedUser.getActive() != null)
            existing.setActive(updatedUser.getActive());

        if (updatedUser.getPassword() != null)
            existing.setPassword(passwordEncoder.encode(updatedUser.getPassword()));

        return userRepository.save(existing);
    }

    // ✅ DELETE (Soft Delete)
    @Override
    public void deleteUser(Long id) {

        User user = getById(id);
        user.setActive(false); // soft delete
        userRepository.save(user);
    }
}