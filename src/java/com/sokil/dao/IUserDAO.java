package com.sokil.dao;


import com.sokil.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    void saveUser(User user) throws SQLException;
    List<User> getAllUsers() throws SQLException;
}
