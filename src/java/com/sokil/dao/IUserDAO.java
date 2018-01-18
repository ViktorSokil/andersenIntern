package com.sokil.dao;


import com.sokil.entity.User;

import java.util.List;

public interface IUserDAO {
    void saveUser(User user);
    List<User> getAllUsers();
}
