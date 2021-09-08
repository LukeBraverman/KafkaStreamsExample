package com.kafkastreamsapplication.model;

import lombok.Data;

public class StringToProcess {

    String message;

    public static StringToProcess innitiliseWithMessage(String message) {
        StringToProcess string = new StringToProcess();
        string.message = message;
        return string;
    }

    public String getMessage() {
        return message;
    }
}
