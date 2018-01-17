package com.sokil.controller;

import com.sokil.entity.User;
import com.sokil.service.IUserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.List;


@Log4j
@NoArgsConstructor
@AllArgsConstructor
@Controller
public class UserController {

    private IUserService userService;

    @RequestMapping(value = "/allusers")
    public ModelAndView listUsers(){
        List<User> list = null;
        try {
            list = userService.getAllUsers();
        } catch (SQLException e) {
            log.error("UserController.insertUser() :" + e.getMessage());
        }
        final ModelAndView modelAndView =
                new ModelAndView("user-page", "list", list);
        return modelAndView;
    }
}
