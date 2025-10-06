package com.example.service;

import com.example.dto.DeviceInfoReqDto;
import com.example.dto.PreorderEventReqDto;
import com.example.mapper.PreorderMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PreorderServiceImpl implements PreorderService {
    private final PreorderMapper preorderMapper;

    public void registerDevice(DeviceInfoReqDto deviceInfoReqDto) {
        preorderMapper.insertDeviceInfo(deviceInfoReqDto);
    }

    public void registerEvent(PreorderEventReqDto preorderEventReqDto) {
        preorderMapper.insertEventInfo(preorderEventReqDto);
    }
}
