package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PreorderEventViewModel {
    private Long id;
    private String eventId;
    private String eventName;
    private String preorderType;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String deviceList;  // JSON 문자열
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

