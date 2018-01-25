package com.sokil.dao.impl;

import com.sokil.dao.IRandomDAO;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Repository("randomDAO")
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class RandomDAOImpl implements IRandomDAO {
    public static final String COLLECTION_NAME = "randomMaps";
    private static AtomicInteger at = new AtomicInteger(1);

    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public void save(Document document) {
        mongoOperations.save(document, COLLECTION_NAME);
    }

    @Override
    public Document findById(Long id) {
        return mongoOperations.findById(id, Document.class, COLLECTION_NAME);
    }

    @Override
    public synchronized void updateField(Long docId, String key, String value) {
        Query query = new Query(Criteria.where("_id").is(docId));
        Update update = new Update();
        update.set(key, value);
        mongoOperations.updateFirst(query, update, COLLECTION_NAME);
    }
}
