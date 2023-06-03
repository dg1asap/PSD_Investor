package com.example.psd_investor;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvestmentController {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    private final ReturnOnInvestmentGenerator returnOnInvestmentGenerator;

    @Value("${investmentTopicName}")
    private String topicName;

    public void publishReturnOnInvestment() {
        ReturnOnInvestmentDto sample = ReturnOnInvestmentDto.builder()
                .value(returnOnInvestmentGenerator.generate())
                .build();
        kafkaTemplate.send(topicName, sample);
    }
}
