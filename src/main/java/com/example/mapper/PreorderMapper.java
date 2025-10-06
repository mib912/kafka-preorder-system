package com.example.mapper;

import com.example.dto.DeviceInfoReqDto;
import com.example.dto.PreorderEventReqDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PreorderMapper {

    void insertDeviceInfo(DeviceInfoReqDto deviceInfoReqDto);

    void insertEventInfo(PreorderEventReqDto preorderEventReqDto);
}
