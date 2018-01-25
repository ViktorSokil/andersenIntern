package com.sokil.controller;

import com.sokil.service.IRandomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RandomDataController {

    @Autowired
    private IRandomService randomService;

    @RequestMapping(value = "/random-page")
    public String randomPage(){
        return "random-page";
    }

    @RequestMapping(value = "/saverandomdata", method = RequestMethod.POST)
    public String insertPerson(HttpServletRequest request){
        randomService.save(request);
        return "random-page";
    }
}
