package com.sokil.service.impl;


import com.sokil.dao.IRandomDAO;
import com.sokil.dao.ISequenceDao;
import com.sokil.service.IRandomService;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service("randomService")
public class RandomServiceImpl implements IRandomService{
    @Autowired
    private IRandomDAO randomDAO;
    @Autowired
    private ISequenceDao sequenceDao;

    @Override
    public void save(HttpServletRequest request) {
        Long id = sequenceDao.getNextSequenceId("randomMaps");
        Document document = new Document();
        document.put("_id", id);
        randomDAO.create(document);
    }
}
