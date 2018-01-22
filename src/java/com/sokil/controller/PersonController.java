package com.sokil.controller;


import com.sokil.dto.PersonDTO;
import com.sokil.service.IPersonServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PersonController {
    @Autowired
    private IPersonServise personServise;

    @RequestMapping(value = "/personregpage", method = RequestMethod.GET)
    public String welcomePage(Model model) {
        model.addAttribute("personDTO", new PersonDTO());
        return "person-reg-page";
    }

    @RequestMapping(value = "/personreg", method = RequestMethod.POST)
    public String insertPerson(@ModelAttribute("personDTO") PersonDTO personDTO){
        personServise.create(personDTO);
        return "person-reg-page";
    }

    @RequestMapping(value = "/allpersons")
    public @ResponseBody List<PersonDTO> listAllPersons(){
        return personServise.getAll();
    }
}
