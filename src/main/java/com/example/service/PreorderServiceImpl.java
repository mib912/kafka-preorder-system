package com.example.service;

import com.example.dto.DeviceInfoReqDto;
import com.example.dto.PreorderEventReqDto;
import com.example.mapper.PreorderMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Slf4j
@Service
@RequiredArgsConstructor
public class PreorderServiceImpl implements PreorderService {
    private final PreorderMapper preorderMapper;

    public void registerDevice(DeviceInfoReqDto deviceInfoReqDto) {
        preorderMapper.insertDeviceInfo(deviceInfoReqDto);
    }

    public void registerEvent(PreorderEventReqDto preorderEventReqDto) {
        preorderMapper.insertEventInfo(preorderEventReqDto); // 이벤트 정보 등록

        // 단말-이벤트 매핑 테이블 등록
        if (!CollectionUtils.isEmpty(preorderEventReqDto.getProductIds())) {
            preorderMapper.insertEventDeviceMap(preorderEventReqDto.getEventId(), preorderEventReqDto.getProductIds());
        }
    }
}
