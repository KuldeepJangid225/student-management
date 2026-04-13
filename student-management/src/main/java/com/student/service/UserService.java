package com.student.service;




import com.student.dto.UserFilterRequest;
import com.student.entity.User;
import org.springframework.data.domain.Page;

public interface UserService {

    User getById(Long id);

    User findByEmail(String email);

    Page<User> getAllUsers(UserFilterRequest request);

    User createUser(User user);

    User updateUser(Long id, User user);

    User patchUser(Long id, User user);

    void deleteUser(Long id);
}
