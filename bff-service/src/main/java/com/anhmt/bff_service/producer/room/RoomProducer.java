package com.anhmt.bff_service.producer.room;

import com.anhmt.bff_service.producer.room.model.RoomCreationProducer;
import com.anhmt.bff_service.properties.KafkaProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class RoomProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final KafkaProperties kafkaProperties;

    public void createRoom(final RoomCreationProducer roomCreationProducer) {
        kafkaTemplate.send(kafkaProperties.getTopic().getRoom(), roomCreationProducer);

        log.info("Sent {}", roomCreationProducer);
    }
}
