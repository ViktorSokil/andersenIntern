package com.sokil.service.impl;


import com.sokil.dao.IRandomDAO;
import com.sokil.service.IRandomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("randomService")
public class RandomServiceImpl implements IRandomService{
    @Autowired
    private IRandomDAO randomDAO;
    /*@Autowired
    private ISequenceDao sequenceDao;*/

    @Override
    public void save(Map<String, String> randomMap) {
        /*Long id = sequenceDao.getNextSequenceId("randomMaps");
        randomDTO.setId(id);*/
        randomDAO.create(randomMap);
    }
}
