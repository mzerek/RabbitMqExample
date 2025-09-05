package com.mzerek.producer_service.mzerekproducer.controller;

import com.mzerek.producer_service.mzerekproducer.model.Animal;
import com.mzerek.producer_service.mzerekproducer.service.MessageProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/publisher/")
public class MessageController {

    private final MessageProducerService messageProducerService;

    @PostMapping("/publish")
    public String sendTerrestrial(@RequestParam(name = "routing-key") String routingKey,
                                  @RequestBody Animal animal) {
        animal.setId(UUID.randomUUID().toString());
        messageProducerService.sendToRabbitMq(animal, routingKey);
        return "Message sent to queue Successfully";
    }

    @GetMapping("/send")
    public String sendMessage(@RequestParam String message) {
        messageProducerService.sendMessage(message);
        return "Message sent: " + message;
    }
}
