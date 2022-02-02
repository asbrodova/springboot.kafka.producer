package dev.asbrodova.springboot.kafka.producer.controllers;

import dev.asbrodova.springboot.kafka.producer.model.Message;
import dev.asbrodova.springboot.kafka.producer.producers.MessageProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
public class MessageRestController {

    private MessageProducerService messageProducerService;

    @Autowired
    public MessageRestController(MessageProducerService messageProducerService) {
        this.messageProducerService = messageProducerService;
    }

    @PostMapping("/put")
    public ResponseEntity<String> putMessageToKafka(@RequestBody Message message){
        messageProducerService.produce(message);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
