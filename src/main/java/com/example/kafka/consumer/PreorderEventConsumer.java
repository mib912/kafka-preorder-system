package com.example.kafka.consumer;

import com.example.dto.PreorderEventMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class PreorderEventConsumer {
    private final PreorderConsumerService preorderConsumerService;

    @KafkaListener(topics = "preorder-event", groupId = "preorder-group")
    public void consume(PreorderEventMessage message) {
        preorderConsumerService.processPreorderEvent(message);
    }
}
