package com.sokil.dao.impl;

import com.sokil.dao.IRandomDAO;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

@Repository("randomDAO")
@Scope("prototype")
public class RandomDAOImpl implements IRandomDAO {
    public static final String COLLECTION_NAME = "randomMaps";

    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public void create(Document document) {
        mongoOperations.save(document, COLLECTION_NAME);
    }
}
