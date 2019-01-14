package com.example.stream.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface Channel {

    String IN = "in";
    String OUT = "out";

    @Input
    SubscribableChannel in();

    @Output
    MessageChannel out();

}