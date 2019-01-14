package com.example.stream.jms;

import com.example.stream.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@ConditionalOnProperty(name = "feature.jms", havingValue = "true")
public class JmsSubscriber {

    private static final String QUEUE = "jms";

    @JmsListener(destination = QUEUE)
    public void subscribe(final Message message) {
        log.info("subscribe() {}", message);
    }

}
