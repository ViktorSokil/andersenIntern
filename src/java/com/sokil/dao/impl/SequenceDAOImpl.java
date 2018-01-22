package com.sokil.dao.impl;

import com.sokil.dao.ISequenceDao;
import com.sokil.dto.Sequence;
import com.sokil.exeptions.SequenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class SequenceDAOImpl implements ISequenceDao {

    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public Long getNextSequenceId(String key) {
        // получаем объект Sequence по наименованию коллекции
        Query query = new Query(Criteria.where("_id").is(key));

        // увеличиваем поле sequence на единицу
        Update update = new Update();
        update.inc("sequence", 1);

        // указываем опцию, что нужно возвращать измененный объект
        FindAndModifyOptions options = new FindAndModifyOptions();
        options.returnNew(true);

        // немного магии :)
        Sequence sequence = mongoOperations.findAndModify(query, update, options, Sequence.class);

        Long seq = sequence.getSequence();
        String id = sequence.getId();

        // if no sequence throws SequenceException
        if(sequence == null) {
            throw new SequenceException("Unable to get sequence for key: " + key);
        }


        return sequence.getSequence();
    }
}
