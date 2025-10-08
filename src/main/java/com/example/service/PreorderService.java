package com.example.service;

import com.example.dto.DeviceInfoDto;
import com.example.dto.PreorderEventReqDto;

import java.util.List;

public interface PreorderService {

    public void registerDevice(DeviceInfoDto deviceInfoDto);

    public void registerEvent(PreorderEventReqDto message);

    public List<DeviceInfoDto> getDevicesByEventId(String eventId);
}
