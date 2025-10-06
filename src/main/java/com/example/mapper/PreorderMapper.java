package com.example.mapper;

import com.example.dto.DeviceInfoReqDto;
import com.example.dto.PreorderEventReqDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PreorderMapper {

    void insertDeviceInfo(DeviceInfoReqDto deviceInfoReqDto);

    void insertEventInfo(PreorderEventReqDto preorderEventReqDto);

    void insertEventDeviceMap(@Param("eventId") String eventId, @Param("productIds") List<String> productIds);
}
