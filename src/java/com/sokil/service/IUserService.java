package com.sokil.service;

import com.sokil.entity.User;

import java.util.List;

public interface IUserService {
    void saveUser(User user);
    List<User> getAllUsers();
}
