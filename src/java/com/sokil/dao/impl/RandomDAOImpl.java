package com.sokil.dao.impl;

import com.sokil.dao.IRandomDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository("randomDAO")
public class RandomDAOImpl implements IRandomDAO {
    public static final String COLLECTION_NAME = "randomMaps";

    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public void create(Map<String, String> randomMap) {
        mongoOperations.insert(randomMap, COLLECTION_NAME);
    }
}
