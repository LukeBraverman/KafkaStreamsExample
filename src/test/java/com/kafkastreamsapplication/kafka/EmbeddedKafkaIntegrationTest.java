//package com.kafkastreamsapplication.kafka;
//
//import com.kafkastreamsapplication.config.KafkaProducerConfig;
//import com.kafkastreamsapplication.consumer.KafkaConsumer;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.kafka.test.context.EmbeddedKafka;
//import org.springframework.test.annotation.DirtiesContext;
//
//import java.util.concurrent.TimeUnit;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//
//@SpringBootTest
//@DirtiesContext
//@EmbeddedKafka(partitions = 1, brokerProperties = { "listeners=PLAINTEXT://localhost:9092", "port=9092" })
//public class EmbeddedKafkaIntegrationTest {
//        @Autowired
//        KafkaProducerConfig kafkaProducerConfig;
//
//    @Autowired
//    private KafkaConsumer consumer;
////
////    @Autowired
////    private KafkaProducer producer;
////
//    @Value("${test.topic}")
//    private String topic;
//
//    @Test
//    public void givenEmbeddedKafkaBroker_whenSendingtoSimpleProducer_thenMessageReceived()
//            throws Exception {
//        kafkaProducerConfig.kafkaStringTemplate().send("TestMessage",topic);
////        producer.send(topic, "Sending with own simple KafkaProducer");
//            consumer.getLatch().await(10000, TimeUnit.MILLISECONDS);
//
//        System.out.println("-------------------------------------");
//        System.out.println(consumer.getPayload());
//        System.out.println("-------------------------------------");
//
//    }
//
//}
