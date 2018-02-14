package com.sokil.service;


import com.sokil.dto.PersonDTO;

import java.util.List;

public interface IPersonServise {
    void create(PersonDTO p);

    void save(PersonDTO p);

    PersonDTO readById(String id);

    void update(PersonDTO p);

    int deleteById(String id);

    List<PersonDTO> getAll();

    void remove(Long id);
}
