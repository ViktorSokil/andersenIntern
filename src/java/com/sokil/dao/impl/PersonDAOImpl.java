package com.sokil.dao.impl;

import com.sokil.dao.IPersonDAO;
import com.sokil.dto.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository("personDAO")
public class PersonDAOImpl implements IPersonDAO {
	@Autowired
	//@Qualifier("mongoTemplate")
	private MongoOperations mongoOps;

	private static final String PERSON_COLLECTION = "Person";

	public PersonDAOImpl() {
	}

	public PersonDAOImpl(MongoOperations mongoOps){
		this.mongoOps=mongoOps;
	}

	public void create(PersonDTO p) {
		this.mongoOps.insert(p, PERSON_COLLECTION);
	}

	public PersonDTO readById(String id) {
		Query query = new Query(Criteria.where("_id").is(id));
		return this.mongoOps.findOne(query, PersonDTO.class, PERSON_COLLECTION);
	}

	public void update(PersonDTO p) {
		this.mongoOps.save(p, PERSON_COLLECTION);
	}

	public int deleteById(String id) {
		/*Query query = new Query(Criteria.where("_id").is(id));
		WriteResult result = this.mongoOps.remove(query, PersonDTO.class, PERSON_COLLECTION);
		return result.getN();*/
		return 5;
	}

}


