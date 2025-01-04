package com.anhmt.bff_service.producer.room;

import com.anhmt.bff_service.producer.room.model.RoomCreationProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class RoomProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void createRoom(final RoomCreationProducer roomCreationProducer) {
        kafkaTemplate.send("${spring.kafka.topic.room}", roomCreationProducer);

        log.info("Sent {}", roomCreationProducer);
    }
}
