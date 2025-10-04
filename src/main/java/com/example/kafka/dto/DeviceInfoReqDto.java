package com.example.kafka.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeviceInfoReqDto {
    private String productId;     // 단말 고유 ID (ex: IP17-PRO-256)
    private String productName;   // 단말 이름
    private String brand;         // 제조사
    private String model;         // 모델명
    private String color;         // 색상
    private String capacity;      // 저장 용량
    private int price;            // 출고가 또는 사전예약가
}
