package com.kish.cloudstream.supplier;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;

@SpringBootApplication
@Slf4j
public class SupplierApplication {

//    @Bean
//    public NewTopic createTopic(){
//        return TopicBuilder.name("test-topic")
//                .partitions(4)
//                .replicas(1)
//                .build();
//    }


    public static void main(String[] args) {
        SpringApplication.run(SupplierApplication.class, args);
    }




}
