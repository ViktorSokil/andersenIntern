package com.sokil.service.impl;

import com.sokil.service.IRandomService;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Slf4j
@Getter
@Setter
@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TaskSaver implements Runnable{

    @Autowired
    private RandomSaver randomSaver;
    @Autowired
    private IRandomService randomService;
    
    private Long docId;
    private String key;
    private String value;

    @Override
    public void run() {
        if (randomService.findById(docId) != null ){
            randomSaver.updateMultiThread(docId, key, value);
        }else {
            log.info("Document with _id = "+docId+" doesn't exist");
        }
    }
}
