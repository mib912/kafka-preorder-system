package com.example.kafka.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 단말 정보 메시지 DTO
 * - 상품 등록/수정 시 Kafka로 발행되는 데이터 구조
 * - Consumer는 이 데이터를 수신하여 DB 갱신 또는 캐싱 처리
 */
@Getter
@Setter
@NoArgsConstructor
public class DeviceInfoMessage {

    private String productId;    // 단말 고유 ID (ex: IP17-PRO-256)
    private String productName;  // 단말 이름 (ex: iPhone 17 Pro)
    private String brand;        // 제조사 (ex: Apple)
    private String model;        // 모델명 (ex: iPhone 17 Pro)
    private String color;        // 색상 (ex: Deep Blue)
    private String capacity;     // 저장 용량 (ex: 256GB)
    private int price;           // 출고가 또는 사전예약가 (ex: 1890000)
}
