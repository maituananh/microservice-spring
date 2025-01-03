package com.anhmt.room_service.consumer;

import com.anhmt.room_service.consumer.mapper.RoomConsumerMapper;
import com.anhmt.room_service.consumer.model.RoomCreationConsumer;
import com.anhmt.room_service.presenter.RoomStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class RoomConsumer {

    private final RoomStore roomStore;

    @KafkaListener(groupId = "${spring.kafka.group.room}", topics = "${spring.kafka.topic.room}")
    public void createRoom(final RoomCreationConsumer roomCreationConsumer) {
        log.info("Creating room {}", roomCreationConsumer.getRoomName());

        var room = roomStore.save(RoomConsumerMapper.INSTANCE.toRoomEntity(roomCreationConsumer));

        log.info("Created the room {}", room.toString());
    }
}
