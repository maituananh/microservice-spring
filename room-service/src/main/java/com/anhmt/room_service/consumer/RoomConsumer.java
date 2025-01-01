package com.anhmt.room_service.consumer;

import com.anhmt.room_service.consumer.model.RoomCreationConsumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RoomConsumer {

    @KafkaListener(groupId = "${spring.kafka.group.room}", topics = "${spring.kafka.topic.room}")
    public void createRoom(RoomCreationConsumer roomCreationConsumer) {
        log.info("Creating room {}", roomCreationConsumer.getRoomName());
    }
}
