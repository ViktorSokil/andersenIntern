package com.sokil.service;


import com.sokil.dto.PersonDTO;

public interface IPersonServise {
    public void create(PersonDTO p);

    public PersonDTO readById(String id);

    public void update(PersonDTO p);

    public int deleteById(String id);
}
