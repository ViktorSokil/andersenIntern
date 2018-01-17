package com.sokil.service;

import com.sokil.dto.UserDTO;
import com.sokil.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserService {
    void saveUser(UserDTO user) throws SQLException;
    List<User> getAllUsers() throws SQLException;
}
