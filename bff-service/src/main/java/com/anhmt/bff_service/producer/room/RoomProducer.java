package com.anhmt.bff_service.producer.room;

import com.anhmt.bff_service.producer.room.model.RoomCreationProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoomProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void createRoom(final RoomCreationProducer roomCreationProducer) {
        kafkaTemplate.send("rooms", roomCreationProducer);
    }
}
