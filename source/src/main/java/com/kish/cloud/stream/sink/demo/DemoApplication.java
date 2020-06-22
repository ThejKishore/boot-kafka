package com.kish.cloud.stream.sink.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;


@SpringBootApplication
@EnableBinding(Source.class)
@RestController
@Slf4j
public class DemoApplication {

    @Autowired
    public MessageChannel output;


    @PostMapping("/publishBook")
    public ResponseEntity<Book> publishBook(@RequestBody Book book){
        log.info(" inside post method {} ",book);
        HashMap<String,String> testHeaders = new HashMap<>();
        testHeaders.put("header","header1");
        Message<Book> message = MessageBuilder.withPayload(book).build();
        boolean asd = output.send(message,3000l);
        log.info(" message published successfully {} ",asd);
        return ResponseEntity.ok(book);
    }


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
