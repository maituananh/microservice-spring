package com.anhmt.booking_service.consumer;

import com.anhmt.booking_service.consumer.mapper.BookingRoomConsumerMapper;
import com.anhmt.booking_service.consumer.model.BookingRoomDto;
import com.anhmt.booking_service.presenter.store.BookingRoomStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class BookingRoomConsumer {

    private final BookingRoomStore bookingRoomStore;

    @KafkaListener(topics = "${spring.kafka.topic.booking-room}")
    public void handle(BookingRoomDto bookingRoomDto) {
        log.info("Received booking room: {}", bookingRoomDto.toString());

        var domain = BookingRoomConsumerMapper.INSTANCE.toBookingRoom(bookingRoomDto);
        bookingRoomStore.save(domain);

        // send mail created room.
    }
}
