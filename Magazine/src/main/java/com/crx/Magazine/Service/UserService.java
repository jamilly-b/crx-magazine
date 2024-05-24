package com.crx.Magazine.Service;

import com.crx.Magazine.Models.Entities.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Integer id);
    User findByEmail(String email);
    User save(User user);

}
