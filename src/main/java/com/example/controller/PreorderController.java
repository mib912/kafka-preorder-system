package com.example.controller;

import com.example.dto.DeviceInfoDto;
import com.example.dto.PreorderEventDto;
import com.example.kafka.producer.PreorderProducerService;
import com.example.service.PreorderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/preorder")
@RequiredArgsConstructor
public class PreorderController {
    private final PreorderService preorderService;
    private final PreorderProducerService preorderProducerService;

    @PostMapping("/device")
    public ResponseEntity<String> registerDevice(@RequestBody DeviceInfoDto deviceInfoDto) {
        preorderService.registerDevice(deviceInfoDto);
        return ResponseEntity.ok("✅ 단말 정보 등록 및 메시지 발행 완료");
    }

    /**
     * 이벤트 정보 등록 + Kafka 발행
     */
    @PostMapping("/event")
    public ResponseEntity<String> registerEvent(@RequestBody PreorderEventDto preorderEventDto) {
        preorderService.registerEvent(preorderEventDto); // db 저장

        preorderService.publishEventMessage(preorderEventDto.getEventId()); // kafka 메시지 발행
        return ResponseEntity.ok("✅ 이벤트 정보 등록 및 메시지 발행 완료");
    }

    /**
     * 이벤트별 단말 조회
     */
    @GetMapping("/events/{eventId}/devices")
    public List<DeviceInfoDto> getDevicesByEventId(@PathVariable("eventId") String eventId) {
        return preorderService.getDevicesByEventId(eventId);
    }

    /**
     * 이벤트 정보 수정 + Kafka 발행
     */
    @PutMapping("/event-upt/{eventId}")
    public ResponseEntity<String> updateEvent(@PathVariable("eventId") String eventId, @RequestBody PreorderEventDto preorderEventDto) {
        preorderService.updateEvent(eventId, preorderEventDto); // db 저장

        preorderService.publishEventMessage(preorderEventDto.getEventId()); // kafka 메시지 발행
        return ResponseEntity.ok("✅ 이벤트 정보 수정 및 메시지 발행 완료");
    }
}
