package com.sokil.service.impl;

import com.sokil.dao.IRandomDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Service("randomSaver")
public class RandomSaver {
    private static AtomicInteger at;

    @Autowired
    private ObjectFactory<IRandomDAO> prototypeFactory;

    public static void setAt(AtomicInteger at) {
        RandomSaver.at = at;
    }

    public static AtomicInteger getAt() {
        return at;
    }

    public synchronized void updateMultiThread(Long docId, String key, String value) {
        while (at.get() != Integer.valueOf(key)){
            try {
                wait();
            } catch (InterruptedException e) {
                log.error("RandomDAOImpl.updateField " + e.getMessage());
            }
        }
        log.debug("Thread "+Thread.currentThread().getName()+" Key - "+key);
        IRandomDAO randomDAO = prototypeFactory.getObject();
        log.debug("Bean randomDAO " + randomDAO.toString());
        randomDAO.updateField(docId, key, value);
        at.incrementAndGet();
        notifyAll();
    }
}
