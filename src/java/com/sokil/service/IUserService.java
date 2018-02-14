package com.sokil.service;

import com.sokil.entity.User;

import java.util.List;

public interface IUserService {
    void createuser(User user);
    void saveUser(User user);
    List<User> getAllUsers();
}
