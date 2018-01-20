package com.sokil.dao;


import com.sokil.dto.PersonDTO;

public interface IPersonDAO {

	public void create(PersonDTO p);
	
	public PersonDTO readById(String id);
	
	public void update(PersonDTO p);
	
	public int deleteById(String id);
}
