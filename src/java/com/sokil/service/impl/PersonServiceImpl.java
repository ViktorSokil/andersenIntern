package com.sokil.service.impl;

import com.sokil.dao.IPersonDAO;
import com.sokil.dto.PersonDTO;
import com.sokil.service.IPersonServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("personServise")
public class PersonServiceImpl implements IPersonServise {
    @Autowired
    private IPersonDAO personDAO;

    @Override
    public void create(PersonDTO p) {
        personDAO.create(p);
    }

    @Override
    public PersonDTO readById(String id) {
        return null;
    }

    @Override
    public void update(PersonDTO p) {
        personDAO.update(p);
    }

    @Override
    public int deleteById(String id) {
        return personDAO.deleteById(id);
    }
}
