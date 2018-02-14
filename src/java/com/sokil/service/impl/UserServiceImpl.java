package com.sokil.service.impl;

import com.sokil.dao.IUserDAO;
import com.sokil.entity.User;
import com.sokil.massaging.MessagePublisher;
import com.sokil.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements IUserService{
    @Autowired
    private IUserDAO userDAO;
    @Autowired
    private MessagePublisher messageSender;

    @Override
    public void createuser(User user) {

    }

    @Override
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }
}
