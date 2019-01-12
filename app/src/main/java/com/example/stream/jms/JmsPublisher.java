package com.example.stream.jms;

import com.example.stream.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JmsPublisher {

    private static final String QUEUE = "jms";

    @Autowired
    private JmsTemplate jms;

    @Scheduled(initialDelay = 5000, fixedRate = 5000)
    public void publish() {
        log.info("publish()");
        jms.convertAndSend(QUEUE,
            new Message()
                .setBody("jms"));
    }

}
