package com.example.controller;

import com.example.dto.DeviceInfoReqDto;
import com.example.dto.PreorderEventReqDto;
import com.example.service.PreorderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/preorder")
@RequiredArgsConstructor
public class PreorderController {
    private final PreorderService preorderService;

    @PostMapping("/device")
    public ResponseEntity<String> registerDevice(@RequestBody DeviceInfoReqDto deviceInfoReqDto) {
        preorderService.registerDevice(deviceInfoReqDto);
        return ResponseEntity.ok("✅ 단말 정보 등록 및 메시지 발행 완료");
    }

    /**
     * 이벤트 정보 등록 + Kafka 발행
     */
    @PostMapping("/event")
    public ResponseEntity<String> registerEvent(@RequestBody PreorderEventReqDto preorderEventReqDto) {
        preorderService.registerEvent(preorderEventReqDto);
        return ResponseEntity.ok("✅ 이벤트 정보 등록 및 메시지 발행 완료");
    }
}
