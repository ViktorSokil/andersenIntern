package com.sokil.dao;


import com.sokil.dto.PersonDTO;

import java.util.List;

public interface IPersonDAO {

	void create(PersonDTO p);
	
	PersonDTO readById(String id);
	
	void update(PersonDTO p);
	
	int deleteById(String id);

	List<PersonDTO> getAll();

	void remove(Long id);
}
