package com.student.service;



import com.student.entity.User;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;

public interface UserService {
    void register(User user);


    User findByUsername(String username);
}
