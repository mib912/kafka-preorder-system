package com.example.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PreorderEventReqDto {
    private String eventId;             // 이벤트 고유 ID (ex: E20251010-01)
    private String eventName;           // 이벤트 이름
    private String startTime;           // 이벤트 시작 시각 (ISO 8601)
    private String endTime;             // 이벤트 종료 시각 (ISO 8601)
    private String preorderType;        // 예약 방식 (online, offline, mixed)
    private String benefitDescription;  // 혜택 설명 (옵션)
    private Integer maxOrderPerUser;    // 1인당 예약 가능 수량 (옵션)

    private List<String> productIds;
}
