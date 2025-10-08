package com.example.kafka.consumer;

import com.example.dto.PreorderEventMessage;
import com.example.dto.PreorderEventViewModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class PreorderConsumerService {
    private final PreorderEventViewMapper preorderEventViewMapper;

    @Transactional
    public void processPreorderEvent(PreorderEventMessage message) {
        PreorderEventViewModel preorderEventViewModel = buildViewModel(message);

        preorderEventViewMapper.upsertEventView(preorderEventViewModel);
    }

    private PreorderEventViewModel buildViewModel(PreorderEventMessage message) {
        // msg > model 변환
        return PreorderEventViewModel.builder()
                .eventId(message.getEventId())
                .eventName(message.getEventName())
                .preorderType(message.getPreorderType())
                .startTime(message.getStartTime())
                .endTime(message.getEndTime())
                .deviceList(toJson(message.getDevices()))
                .build();
    }

    private String toJson(Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            log.error("JSON 변환 실패", e.getMessage());
            return "[]";
        }
    }

    public Map<String, Object> getPreorderEventView(String eventId) {
        PreorderEventViewModel model = preorderEventViewMapper.selectEventView(eventId);

        if (model == null) {
            return null;
        }

        Map<String, Object> response = new LinkedHashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();

        response.put("eventId", model.getEventId());
        response.put("eventName", model.getEventName());
        response.put("preorderType", model.getPreorderType());
        response.put("startTime", model.getStartTime());
        response.put("endTime", model.getEndTime());
        response.put("createdAt", model.getCreatedAt());
        response.put("updatedAt", model.getUpdatedAt());

        try {
            // 문자열을 JSON 객체로 파싱해서 넣음
            response.put("deviceList", objectMapper.readValue(model.getDeviceList(), Object.class));
        } catch (Exception e) {
            log.error("deviceList JSON 파싱 실패: {}", e.getMessage());
            response.put("deviceList", null);
        }

        return response;
    }
}
