package com.sokil.service.impl;

import com.sokil.dao.IUserDAO;
import com.sokil.dto.UserDTO;
import com.sokil.entity.User;
import com.sokil.service.IUserService;
import com.sokil.utils.Util;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
public class UserServiceImpl implements IUserService{
    private IUserDAO userDAO;

    @Override
    public void saveUser(UserDTO userDTO) throws SQLException {
        Set<String> roles = Util.parseRoles(userDTO.getRoles());
        User user = new User();
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
