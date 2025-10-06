package com.example.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 사전예약 이벤트 정보 DTO
 * - 이벤트 등록 또는 수정 시 Kafka로 발행되는 메시지 구조
 * - Consumer는 이를 수신하여 이벤트 DB 갱신 또는 캐시 업데이트에 사용
 */
@Getter
@Setter
@NoArgsConstructor
public class PreorderEventMessage {

    private String eventId;            // 이벤트 고유 ID (ex: E20251010-01)
    private String eventName;          // 이벤트 이름 (ex: iPhone 17 Pro 사전예약 이벤트)
    private String productId;          // 대상 단말 ID
    private String startTime;          // 이벤트 시작 시각
    private String endTime;            // 이벤트 종료 시각
    private String preorderType;       // 예약 방식 (online / offline / mixed)
    private String benefitDescription; // 혜택 설명 (선택)
    private int maxOrderPerUser;       // 1인당 예약 가능 수량 (선택)
}
