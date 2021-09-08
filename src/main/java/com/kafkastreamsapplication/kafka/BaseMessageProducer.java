package com.kafkastreamsapplication.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kafkastreamsapplication.model.StringToProcess;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;


public abstract class BaseMessageProducer {


    private final KafkaTemplate<String, String> kafkaTemplate;



    public BaseMessageProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;

    }


    public void send(final String stringToProcess) throws JsonProcessingException {

        Message<String> stringMessage = MessageBuilder
                .withPayload(stringToProcess)
                .setHeader(KafkaHeaders.TOPIC, "KafkaStreamsEG")
                .build();
        kafkaTemplate.send(stringMessage);


    }
}
