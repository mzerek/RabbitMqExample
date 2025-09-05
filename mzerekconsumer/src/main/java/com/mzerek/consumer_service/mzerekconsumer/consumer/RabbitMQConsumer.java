package com.mzerek.consumer_service.mzerekconsumer.consumer;

import com.mzerek.consumer_service.mzerekconsumer.model.Animal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
@RequiredArgsConstructor
public class RabbitMQConsumer {

    public static final String QUEUE_NAME = "exampleQueue";

    @RabbitListener(queues = "${spring.terrestrial.queue.name}")
    public void receiveTerrestrialQueueMessage(Animal animal){
        log.info(".....Inside receiveTerrestrialQueueMessage");
        System.out.println("CreateMessage :: " + animal);
    }

    @RabbitListener(queues = "${spring.aquatic.queue.name}")
    public void receiveAquaticQueueMessage(Animal animal){
        log.info(".....Inside receiveAquaticQueueMessage");
        System.out.println("CreateMessage :: " + animal);
    }

    @RabbitListener(queues = "${spring.aerial.queue.name}")
    public void receiveAerialQueueMessage(Animal animal){
        log.info(".....Inside receiveAerialQueueMessage");
        System.out.println("CreateMessage :: " + animal);
    }

    @RabbitListener(queues = QUEUE_NAME)
    public void listen(String message){
        System.out.println("Received message: " + message);
    }
}
