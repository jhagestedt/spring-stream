package com.example.stream;

import java.io.Serializable;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Message implements Serializable {

    private String body;

    public Message setBody(String body) {
        this.body = body;
        return this;
    }

}
