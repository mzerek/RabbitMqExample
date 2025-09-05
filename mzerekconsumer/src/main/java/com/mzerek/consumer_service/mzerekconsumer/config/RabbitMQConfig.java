package com.mzerek.consumer_service.mzerekconsumer.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_NAME = "exampleQueue";

    @Value("${spring.topic-exchange.name}")
    private String topicExchange;

    @Value("${spring.terrestrial.queue.name}")
    private String terrestrialQueue;

    @Value("${spring.aquatic.queue.name}")
    private String aquaticQueue;

    @Value("${spring.aerial.queue.name}")
    private String aerialQueue;

    @Value("${spring.terrestrial.queue.routing-key}")
    private String terrestrialQueueRoutingKey;

    @Value("${spring.aquatic.queue.routing-key}")
    private String aquaticQueueRoutingKey;

    @Value("${spring.aerial.queue.routing-key}")
    private String aerialQueueRoutingKey;

    @Bean
    public Queue exampleQueue() {
        return new Queue(QUEUE_NAME, false);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(topicExchange);
    }

    @Bean
    public Queue terrestrialQueue() {
        return new Queue(terrestrialQueue);
    }

    @Bean
    public Queue aquaticQueue() {
        return new Queue(aquaticQueue);
    }

    @Bean
    public Queue aerialQueue() {
        return new Queue(aerialQueue);
    }

    @Bean
    public Binding terrestrialQueueBindingTopic(Queue terrestrialQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(terrestrialQueue).to(topicExchange).with(terrestrialQueueRoutingKey);
    }

    @Bean
    public Binding aquaticQueueBindingTopic(Queue aquaticQueue, TopicExchange topicExchange){
        return BindingBuilder.bind(aquaticQueue).to(topicExchange).with(aquaticQueueRoutingKey);
    }

    @Bean
    public Binding aerialQueueBindingTopic(Queue aerialQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(aerialQueue).to(topicExchange).with(aerialQueueRoutingKey);
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return template;
    }
}
