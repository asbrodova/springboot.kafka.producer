package dev.asbrodova.springboot.kafka.producer.producers;

import dev.asbrodova.springboot.kafka.producer.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducerService {

    private static final String TOPIC = "Messages";

    private Logger logger = LoggerFactory.getLogger(MessageProducerService.class);

    private KafkaTemplate<String, Message> kafkaTemplate;


    @Autowired
    public MessageProducerService(KafkaTemplate<String, Message> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void produce(Message message) {
        logger.info("Producing the message: " + message.toString());
        kafkaTemplate.send(TOPIC, message);
    }
}
