package com.sokil.controller;

import com.sokil.service.IRandomService;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

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
        Map<String, String[]> map = request.getParameterMap();
        Document document = new Document();

        for(Map.Entry<String, String[]> pair: map.entrySet()){
            String key = pair.getKey();
            String value = "";
            for (String str: pair.getValue()){
                value = str;
            }
            document.put(key, value);
        }

        randomService.save(document);
        return "random-page";
    }
}
