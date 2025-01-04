package com.anhmt.bff_service.producer.booking;

import com.anhmt.bff_service.producer.booking.model.BookingCreationProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookingProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void send(final BookingCreationProducer producer) {
        kafkaTemplate.send("", producer);
    }
}
