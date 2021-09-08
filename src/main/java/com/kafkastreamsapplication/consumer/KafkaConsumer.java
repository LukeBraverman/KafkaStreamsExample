package com.kafkastreamsapplication.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;
import java.util.logging.Logger;

@Component
public class KafkaConsumer {


    private CountDownLatch latch = new CountDownLatch(1);
    private String payload = null;

    @KafkaListener(topics = "${test.topic}" )
    public void receive(ConsumerRecord<?, ?> consumerRecord) {
        System.out.println(("received payload='{" +consumerRecord.toString() + "}'" ));
        setPayload(consumerRecord.toString());
        latch.countDown();
    }

    private void setPayload(String toString) {
        payload = toString;
    }

    public CountDownLatch getLatch() {
        return latch;
    }

    public String getPayload() {
        return payload;
    }
}