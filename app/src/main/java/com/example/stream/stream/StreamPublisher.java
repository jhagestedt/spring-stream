package com.example.stream.stream;

import com.example.stream.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@EnableBinding({
    Channel.class
})
@ConditionalOnProperty(name = "feature.stream", havingValue = "true")
public class StreamPublisher {

    @Autowired
    private Channel channel;

    @Scheduled(initialDelay = 5000, fixedRate = 5000)
    public void publish() {
        log.info("publish()");
        channel.out().send(MessageBuilder
            .withPayload(new Message()
                .setBody("stream"))
            .build());
    }

}
