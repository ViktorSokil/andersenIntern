package com.sokil.service.impl;

import com.sokil.dao.IRandomDAO;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Getter
@Setter
@Service("randomSaver")
public class RandomSaver {
    private AtomicInteger count;

    @Autowired
    private ApplicationContext applicationContext;

    public synchronized void updateMultiThread(Long docId, String key, String value) {
        while (count.get() != Integer.valueOf(key)){
            try {
                wait();
            } catch (InterruptedException e) {
                log.error("RandomDAOImpl.updateField " + e.getMessage());
            }
        }
        log.debug("Thread "+Thread.currentThread().getName()+" Key - "+key);
        IRandomDAO randomDAO = applicationContext.getBean(IRandomDAO.class);
        log.debug("Bean randomDAO " + randomDAO.toString());
        randomDAO.updateField(docId, key, value);
        count.incrementAndGet();
        notifyAll();
    }
}
