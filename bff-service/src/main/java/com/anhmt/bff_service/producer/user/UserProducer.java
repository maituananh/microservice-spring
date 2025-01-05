package com.anhmt.bff_service.producer.user;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

}
