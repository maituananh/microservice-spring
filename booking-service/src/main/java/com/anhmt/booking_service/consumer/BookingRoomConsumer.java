package com.anhmt.booking_service.consumer;

import com.anhmt.booking_service.consumer.mapper.BookingRoomConsumerMapper;
import com.anhmt.booking_service.consumer.model.BookingRoomDto;
import com.anhmt.booking_service.consumer.model.BookingRoomReply;
import com.anhmt.booking_service.presenter.store.BookingRoomStore;
import com.anhmt.booking_service.properties.KafkaProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class BookingRoomConsumer {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final KafkaProperties kafkaProperties;
    private final BookingRoomStore bookingRoomStore;

    @KafkaListener(groupId = "${spring.kafka.group.booking-room}", topics = "${spring.kafka.topic.booking-room}")
    public void handle(BookingRoomDto bookingRoomDto) {
        log.info("Received booking room: {}", bookingRoomDto.toString());
//        var reply = BookingRoomReply.builder();

        try {
            var domain = BookingRoomConsumerMapper.INSTANCE.toBookingRoom(bookingRoomDto);
            UUID id = bookingRoomStore.save(domain);
//            reply.status(BookingRoomStatusEnum.SUCCESS)
//                    .payload(BookingRoomReply.Payload.builder()
//                            .roomId(id)
//                            .build());
        } catch (Exception ex) {
            log.error(ex.getMessage());
//            reply.status(BookingRoomStatusEnum.FAIL)
//                    .error(ex.getMessage());
        } finally {
//            sendResultBookingRoom(reply.build());
        }
    }

    public void sendResultBookingRoom(final BookingRoomReply reply) {
        kafkaTemplate.send(kafkaProperties.getTopic().getBookingRoomReply(), reply);
    }
}
