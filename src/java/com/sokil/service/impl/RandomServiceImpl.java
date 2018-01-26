package com.sokil.service.impl;


import com.sokil.dao.IRandomDAO;
import com.sokil.dao.ISequenceDao;
import com.sokil.service.IRandomService;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Service("randomService")
public class RandomServiceImpl implements IRandomService{
    @Autowired
    private IRandomDAO randomDAO;
    @Autowired
    private ISequenceDao sequenceDao;
    @Autowired
    RandomSaver randomSaver;

    @Override
    public void save(HttpServletRequest request) {
        Long id = sequenceDao.getNextSequenceId("randomMaps");
        Document document = new Document();
        document.put("_id", id);
        randomDAO.save(document);
        Map<String, String[]> map = request.getParameterMap();
        ExecutorService executorService = Executors.newFixedThreadPool(map.size());
        randomSaver.setCount(new AtomicInteger(1));
        for (Map.Entry<String, String[]> pair: map.entrySet()){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    if (findById(id) != null ){
                        randomSaver.updateMultiThread(id, pair.getKey(), pair.getValue()[0]);
                    }else {
                        log.info("Document with _id = "+id+" doesn't exist");
                    }
                }
            });
        }
        executorService.shutdown();
    }

    @Override
    public Document findById(Long id) {
        return randomDAO.findById(id);
    }

    @Override
    public void updateField(Long docId, String key, String value) {
        randomDAO.updateField(docId, key, value);
    }
}
