package com.sokil.dao.impl;

import com.mongodb.WriteResult;
import com.sokil.dao.IPersonDAO;
import com.sokil.dto.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("personDAO")
public class PersonDAOImpl implements IPersonDAO {
	@Autowired
	private MongoOperations mongoOps;

	//private static final String PERSON_COLLECTION = "Persons";

	public PersonDAOImpl() {
	}

	public PersonDAOImpl(MongoOperations mongoOps){
		this.mongoOps=mongoOps;
	}

	public void create(PersonDTO p) {
		mongoOps.insert(p);
	}

	public PersonDTO readById(String id) {
		Query query = new Query(Criteria.where("_id").is(id));
		return mongoOps.findOne(query, PersonDTO.class);
	}

	public void update(PersonDTO p) {
		mongoOps.save(p);
	}

	public int deleteById(String id) {
		Query query = new Query(Criteria.where("_id").is(id));
		WriteResult result = mongoOps.remove(query, PersonDTO.class);
		return result.getN();
	}

	public List<PersonDTO> getAll() {
		return mongoOps.findAll(PersonDTO.class);
	}

	public void remove(Long id) {
		mongoOps.remove(Query.query(Criteria.where("_id").is(id)), PersonDTO.class);
	}

}


