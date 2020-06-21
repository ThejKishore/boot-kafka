package com.kish.cloudstream.supplier;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KPublishController {


    private KafkaProducer kafkaProducer;

    public KPublishController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }


    @PostMapping("/publishmesage")
    public ResponseEntity publish(@RequestParam String msg){
            this.kafkaProducer.sendDataToKafka(msg);
            return ResponseEntity.ok("sent the msg");
    }

}
