package com.sokil.service;

import com.sokil.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public interface IUserService {
    void saveUser(HttpServletRequest request) throws SQLException;
    List<User> getAllUsers() throws SQLException;
}
