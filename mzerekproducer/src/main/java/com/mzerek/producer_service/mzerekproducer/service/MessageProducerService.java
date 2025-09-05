package com.mzerek.producer_service.mzerekproducer.service;

import com.mzerek.producer_service.mzerekproducer.model.Animal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static com.mzerek.producer_service.mzerekproducer.config.RabbitMQConfig.QUEUE_NAME;

@RequiredArgsConstructor
@Slf4j
@Service
public class MessageProducerService {

    private final AmqpTemplate amqpTemplate;

    @Value("${spring.topic-exchange.name}")
    private String topicExchangeName;

    public void sendToRabbitMq(Animal animal, String routingKey) {
        amqpTemplate.convertAndSend(topicExchangeName, routingKey, animal);
    }

    public void sendMessage(String message) {
        log.info(String.format("Sending message: %s to queue: %s", message, QUEUE_NAME));
        amqpTemplate.convertAndSend(QUEUE_NAME, message);
    }
}
