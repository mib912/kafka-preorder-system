package com.example.kafka.consumer;

import com.example.dto.PreorderEventViewModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PreorderEventViewMapper {
    int upsertEventView(PreorderEventViewModel preorderEventViewModel);

    PreorderEventViewModel selectEventView(String eventId);
}
