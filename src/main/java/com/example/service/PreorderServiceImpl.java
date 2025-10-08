package com.example.service;

import com.example.dto.DeviceInfoDto;
import com.example.dto.PreorderEventDto;
import com.example.dto.PreorderEventMessage;
import com.example.kafka.producer.PreorderProducerService;
import com.example.mapper.PreorderMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PreorderServiceImpl implements PreorderService {
    private final PreorderMapper preorderMapper;
    private final PreorderProducerService preorderProducerService;

    @Override
    public void registerDevice(DeviceInfoDto deviceInfoDto) {
        preorderMapper.insertDeviceInfo(deviceInfoDto);
    }

    @Override
    @Transactional
    public void registerEvent(PreorderEventDto preorderEventDto) {
        preorderMapper.insertEventInfo(preorderEventDto); // 이벤트 정보 등록

        // 단말-이벤트 매핑 테이블 등록
        if (!CollectionUtils.isEmpty(preorderEventDto.getProductIds())) {
            preorderMapper.insertEventDeviceMap(preorderEventDto.getEventId(), preorderEventDto.getProductIds());
        }
    }

    @Override
    @Transactional
    public void updateEvent(String eventId, PreorderEventDto preorderEventDto) {
        preorderMapper.updateEventInfo(eventId, preorderEventDto);

        preorderMapper.deleteEventDeviceMap(eventId); // 기존 매핑 삭제

        // 단말-이벤트 매핑 테이블 등록
        if (!CollectionUtils.isEmpty(preorderEventDto.getProductIds())) {
            preorderMapper.insertEventDeviceMap(preorderEventDto.getEventId(), preorderEventDto.getProductIds());
        }

        publishEventMessage(eventId);
    }

    @Override
    public List<DeviceInfoDto> getDevicesByEventId(String eventId) {
        return preorderMapper.selectDevicesByEventId(eventId);
    }

    @Override
    public void publishEventMessage(String eventId) {
        PreorderEventDto preorderEventDto = preorderMapper.selectEventById(eventId);
        List<DeviceInfoDto> devices = getDevicesByEventId(eventId);

        // kafka 메시지 생성
        PreorderEventMessage message = PreorderEventMessage.builder()
                .eventId(preorderEventDto.getEventId())
                .eventName(preorderEventDto.getEventName())
                .preorderType(preorderEventDto.getPreorderType())
                .startTime(preorderEventDto.getStartTime())
                .endTime(preorderEventDto.getEndTime())
                .devices(devices)
                .build();

        preorderProducerService.sendPreorderEvent(message);
    }
}
