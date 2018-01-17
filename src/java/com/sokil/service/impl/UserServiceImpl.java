package com.sokil.service.impl;

import com.sokil.dao.IUserDAO;
import com.sokil.dto.UserDTO;
import com.sokil.entity.User;
import com.sokil.service.IUserService;
import com.sokil.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

@Service("userService")
public class UserServiceImpl implements IUserService{
    @Autowired
    private IUserDAO userDAO;

    @Override
    public void saveUser(UserDTO userDTO) throws SQLException {
        Set<String> roles = Util.parseRoles(userDTO.getRoles());
        com.sokil.entity.User user = new com.sokil.entity.User();
        user.setUserName(userDTO.getUserName());
        user.setUserPassword(userDTO.getUserPassword());
        user.setRoles(roles);
        userDAO.saveUser(user);
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> users = userDAO.getAllUsers();
        return users;
    }
}
