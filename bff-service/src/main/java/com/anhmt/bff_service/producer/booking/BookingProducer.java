package com.anhmt.bff_service.producer.booking;

import com.anhmt.bff_service.producer.booking.model.BookingCreationProducer;
import com.anhmt.bff_service.properties.KafkaProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class BookingProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final KafkaProperties kafkaProperties;

    public void send(final BookingCreationProducer producer) {
        kafkaTemplate.send(
                kafkaProperties.getTopic().getBookingRoom(),
                producer);
    }
}
