package com.example.stream.stream;

import com.example.stream.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@EnableBinding({
    Channel.class
})
@ConditionalOnProperty(name = "feature.stream", havingValue = "true")
public class StreamSubscriber {

    @StreamListener(Channel.IN)
    public void subscribe(final Message message) {
        log.info("subscribe() {}", message);
    }

}
