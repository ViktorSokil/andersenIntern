package com.sokil.controller;

import com.sokil.dto.PersonDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RandomDataController {

    @RequestMapping(value = "/random-page")
    public String randomPage(){
        return "random-page";
    }

    @RequestMapping(value = "/saverandomdata", method = RequestMethod.POST)
    public String insertPerson(@ModelAttribute("personDTO") PersonDTO personDTO){
        return "person-reg-page";
    }
}
