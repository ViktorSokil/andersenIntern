package com.sokil.service.impl;

import com.sokil.dao.IUserDAO;
import com.sokil.entity.User;
import com.sokil.service.IUserService;
import com.sokil.utils.Util;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public class UserServiceImpl implements IUserService{
    private IUserDAO userDAO;

    public UserServiceImpl(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void saveUser(HttpServletRequest request) throws SQLException {
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("password");
        String userRoles = request.getParameter("role");
        Set<String> roles = Util.parseRoles(userRoles);
        User user = new User();
        user.setUserName(userName);
        user.setUserPassword(userPassword);
        user.setRoles(roles);
        userDAO.saveUser(user);
    }

    public List<User> getAllUsers() throws SQLException {
        return userDAO.getAllUsers();
    }


}
