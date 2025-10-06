package com.example.service;

import com.example.dto.DeviceInfoReqDto;
import com.example.dto.PreorderEventReqDto;

public interface PreorderService {

    public void registerDevice(DeviceInfoReqDto deviceInfoReqDto);

    public void registerEvent(PreorderEventReqDto message);
}
