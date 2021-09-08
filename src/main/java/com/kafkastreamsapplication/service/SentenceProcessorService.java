package com.kafkastreamsapplication.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kafkastreamsapplication.kafka.MessageProducer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SentenceProcessorService {

    private MessageProducer messageProducer;

    public String returnWordCountFromStringUsingKafkaStreams(String messageToProcess) throws JsonProcessingException {
        //send to kafka
        messageProducer.send(messageToProcess);
        //receive from kafka using stream

        //process

        //format into human readable string



        return messageToProcess;
    }
}
