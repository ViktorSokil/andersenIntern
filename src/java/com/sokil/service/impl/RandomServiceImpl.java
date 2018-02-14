package com.sokil.service.impl;


import com.sokil.dao.IRandomDAO;
import com.sokil.dao.ISequenceDao;
import com.sokil.service.IRandomService;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Service("randomService")
public class RandomServiceImpl implements IRandomService{
    @Autowired
    private IRandomDAO randomDAO;
    @Autowired
    private ISequenceDao sequenceDao;
    @Autowired
    private RandomSaver randomSaver;
    @Autowired
    private ApplicationContext applicationContext;

    private ExecutorService taskExecutor;

    private AtomicInteger count = new AtomicInteger(1);

    @Override
    public void save(HttpServletRequest request) {
        Long id = sequenceDao.getNextSequenceId("randomMaps");

        Document document = new Document();
        document.put("_id", id);
        randomDAO.save(document);

        Map<String, String[]> map = request.getParameterMap();

        taskExecutor = Executors.newFixedThreadPool(map.size());

        randomSaver.setCount(count);
        for (Map.Entry<String, String[]> pair: map.entrySet()){

            TaskSaver taskSaver = applicationContext.getBean(TaskSaver.class);
            taskSaver.setDocId(id);
            taskSaver.setKey(pair.getKey());
            taskSaver.setValue(pair.getValue()[0]);

            taskExecutor.submit(taskSaver);
        }
        taskExecutor.shutdown();
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
