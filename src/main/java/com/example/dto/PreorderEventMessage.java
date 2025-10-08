package com.example.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 사전예약 이벤트 정보 DTO
 * - 이벤트 등록 또는 수정 시 Kafka로 발행되는 메시지 구조
 * - Consumer는 이를 수신하여 이벤트 DB 갱신 또는 캐시 업데이트에 사용
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PreorderEventMessage {

    private String eventId;
    private String eventName;
    private String preorderType;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;
    private List<DeviceInfoDto> devices;
}
