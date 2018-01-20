package com.sokil.controller;

import com.sokil.dto.UserDTO;
import com.sokil.entity.Role;
import com.sokil.entity.User;
import com.sokil.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/allusers")
    public List<UserDTO> listUsers(){
        return userDTOList(userService.getAllUsers());
    }

    private UserDTO parseToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setUserName(user.getUserName());
        StringBuilder roles = new StringBuilder();
        for (Role role: user.getRoles()){
            roles.append(role.getRole()).append(", ");
        }
        userDTO.setRoles(roles.toString());
        return userDTO;
    }

    private List<UserDTO> userDTOList(List<User> users){
        List<UserDTO> userDTOS = new ArrayList<>();
        for (User user: users){
            userDTOS.add(parseToUserDTO(user));
        }
        return userDTOS;
    }
}
