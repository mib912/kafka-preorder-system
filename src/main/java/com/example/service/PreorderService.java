package com.example.service;

import com.example.dto.DeviceInfoDto;
import com.example.dto.PreorderEventDto;

import java.util.List;

public interface PreorderService {

    public void registerDevice(DeviceInfoDto deviceInfoDto);

    public void registerEvent(PreorderEventDto message);

    public List<DeviceInfoDto> getDevicesByEventId(String eventId);

    public void publishEventMessage(String eventId);

    public void updateEvent(String eventId, PreorderEventDto preorderEventDto);
}
