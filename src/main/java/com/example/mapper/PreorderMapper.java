package com.example.mapper;

import com.example.dto.DeviceInfoDto;
import com.example.dto.PreorderEventReqDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PreorderMapper {

    int insertDeviceInfo(DeviceInfoDto deviceInfoDto);

    int insertEventInfo(PreorderEventReqDto preorderEventReqDto);

    int insertEventDeviceMap(@Param("eventId") String eventId, @Param("productIds") List<String> productIds);

    List<DeviceInfoDto> selectDevicesByEventId(@Param("eventId") String eventId);
}
