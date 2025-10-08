# 📱 Phone Preorder Event (Kafka + Spring Boot)

## 📝 프로젝트 개요
Kafka를 활용해 **사전예약 이벤트 정보를 실시간으로 처리**하는 토이 프로젝트입니다.  
Producer를 통해 이벤트 정보를 Kafka로 송신하고, Consumer가 이를 수신해 DB에 저장 및 조회할 수 있도록 구성했습니다.

---

## 🧱 기술 스택
- **Backend**: Spring Boot 3.x (Java), MyBatis  
- **Messaging**: Apache Kafka (Docker Compose)  
- **Database**: MySQL 8.x  
- **Build Tool**: Maven

---

## 🧭 아키텍처 개요

[Producer]  →  [Kafka Broker]  →  [Consumer]  →  [DB 저장 / 조회 API]

Producer: 이벤트 정보를 JSON 메시지 형태로 Kafka 토픽에 발행

Kafka Broker: 메시지를 토픽 단위로 저장 및 Consumer에게 전달

Consumer: 수신한 이벤트 데이터를 DB에 upsert

API: 저장된 이벤트를 조회하여 JSON 형태로 반환


### 📎 참고
 👉 [노션 문서] (https://www.notion.so/Kafka-281c147b37dd8011a036c0d122ee91a8)


### 🌱 향후 개선점

Kafka 파티션 확장을 통한 부하 분산 테스트

Consumer 그룹 스케일링 실험

장애 상황에서의 메시지 재처리 로직 구현
