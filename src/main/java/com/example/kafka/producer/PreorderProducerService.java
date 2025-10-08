package com.example.kafka.producer;

import com.example.dto.PreorderEventMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PreorderProducerService {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    private static final String PREORDER_TOPIC = "preorder-event";

    public void sendPreorderEvent(PreorderEventMessage message) {
        kafkaTemplate.send(PREORDER_TOPIC, message);
    }
}
