package com.sokil.massaging;

import com.sokil.dto.PersonDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessagePublisher {

    @Autowired
    JmsTemplate jmsTemplate;

    private static final String RANDOM_DATA_TOPIC = "random_data_topic";

    public void sendMessage(PersonDTO personDTO) {
        log.info("------");
        jmsTemplate.convertAndSend(RANDOM_DATA_TOPIC, personDTO);
        log.info("Convert and send");
    }

}
