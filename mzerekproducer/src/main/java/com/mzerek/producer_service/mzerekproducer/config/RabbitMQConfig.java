package com.mzerek.producer_service.mzerekproducer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.amqp.core.Queue;
@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_NAME = "exampleQueue";

    @Bean
    public Queue exampleQueue(){
        return new Queue(QUEUE_NAME, false);
    }
}
