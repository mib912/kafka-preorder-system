package com.example.kafka.consumer;

import com.example.dto.PreorderEventViewModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/preorder-event-view")
public class PreorderConsumerController {
    private final PreorderConsumerService preorderConsumerService;

    @GetMapping("/{eventId}")
    public Map<String, Object> getPreorderEventView(@PathVariable String eventId) {
        return preorderConsumerService.getPreorderEventView(eventId);
    }
}
