package com.kish.cloud.stream.sink.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@EnableBinding(Sink.class)
@RestController
@Slf4j
public class SinkDemoApplication {


    @StreamListener(Sink.INPUT)
    public void consumeMessage(Book book){
        log.info(" message received {} ",book);
    }

    public static void main(String[] args) {
        SpringApplication.run(SinkDemoApplication.class, args);
    }

}
