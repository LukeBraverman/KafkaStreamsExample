package com.kafkastreamsapplication.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kafkastreamsapplication.model.StringToProcess;
import com.kafkastreamsapplication.service.SentenceProcessorService;
import lombok.AllArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;
import java.util.logging.Logger;

@Component
@AllArgsConstructor
public class KafkaConsumer {
    private SentenceProcessorService sentenceProcessorService;

    @org.springframework.kafka.annotation.KafkaListener(topics = "KafkaStreamsEG", groupId = "ESTEST")
    public void ListenerOnTopicES_TEST_TOPIC(String message) {
        System.out.println("received message: " + message);
        try {


        } catch (JsonProcessingException e) {
            System.out.println("Not A JSON string");
            e.printStackTrace();
        }


    }

}