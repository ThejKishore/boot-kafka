package com.kish.cloudstream.supplier;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Configuration
@Slf4j
public class KafkaProducer {


    @Value("${my.kafka.producer.topic:test-in-0}")
    private String topic;

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    public void sendDataToKafka(String data) {

        ListenableFuture<SendResult<String, String>> listenableFuture = kafkaTemplate.send(topic,data);

        listenableFuture.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.info("Sent data   {} , topic {} , partition {}", result.getProducerRecord().value(),topic,result.getRecordMetadata().partition());
            }

            @Override
            public void onFailure(Throwable ex) {
                log.error("Unable to send data to Kafka", ex);
            }
        });
    }
}

