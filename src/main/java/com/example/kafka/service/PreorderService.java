package com.example.kafka.service;

import com.example.kafka.dto.DeviceInfoMessage;
import com.example.kafka.dto.DeviceInfoReqDto;
import com.example.kafka.dto.PreorderEventReqDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PreorderService {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void registerDevice(DeviceInfoReqDto message) {
        // TODO: 나중에 DB 저장 + 비즈니스 로직 추가
        kafkaTemplate.send("device-info-topic", message.getProductId(), message);
    }

    public void registerEvent(PreorderEventReqDto message) {
        // TODO: 나중에 DB 저장 + 검증 로직 추가
        kafkaTemplate.send("preorder-events-topic", message.getProductId(), message);
    }
}
