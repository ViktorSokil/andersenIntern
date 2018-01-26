package com.sokil.dao.impl;

import com.sokil.dao.IRandomDAO;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository("randomDAO")
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class RandomDAOImpl implements IRandomDAO {
    public static final String COLLECTION_NAME = "randomMaps";

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void save(Document document) {
        MongoOperations mongoOperations = applicationContext.getBean(MongoOperations.class);
        mongoOperations.save(document, COLLECTION_NAME);
    }

    @Override
    public Document findById(Long id) {
        MongoOperations mongoOperations = applicationContext.getBean(MongoOperations.class);
        return mongoOperations.findById(id, Document.class, COLLECTION_NAME);
    }

    @Override
    public void updateField(Long docId, String key, String value) {
        Query query = new Query(Criteria.where("_id").is(docId));
        Update update = new Update();
        update.set(key, value);
        MongoOperations mongoOperations = applicationContext.getBean(MongoOperations.class);
        mongoOperations.updateFirst(query, update, COLLECTION_NAME);
        log.debug("MongoTemplate " + mongoOperations);
    }
}
