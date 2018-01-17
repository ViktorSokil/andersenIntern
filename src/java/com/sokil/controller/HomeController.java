package com.sokil.controller;

import com.sokil.dto.UserDTO;
import com.sokil.service.IRoleService;
import com.sokil.service.IUserService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;

@Log4j
@Controller
public class HomeController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcomePage(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String insertUser(@ModelAttribute("userDTO") UserDTO user){
        try {
            roleService.saveRole(user);
            userService.saveUser(user);
        } catch (SQLException ex ) {
            log.error("HomeController.insertUser() :" + ex.getMessage());
        }
        return "registration";
    }
}
