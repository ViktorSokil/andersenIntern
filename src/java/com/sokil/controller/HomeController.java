package com.sokil.controller;

import com.sokil.dto.UserDTO;
import com.sokil.entity.Role;
import com.sokil.entity.User;
import com.sokil.service.IUserService;
import com.sokil.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Set;

@Controller
public class HomeController {
    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcomePage(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String insertUser(@ModelAttribute("userDTO") UserDTO userDTO){
        userService.saveUser(parseToUser(userDTO));
        return "registration";
    }

    private User parseToUser(UserDTO userDTO){
        Set<Role> roles = Util.parseRoles(userDTO.getRoles());
        User user = new User();
        user.setUserName(userDTO.getUserName());
        user.setUserPassword(userDTO.getUserPassword());
        user.setRoles(roles);
        return user;
    }
}
