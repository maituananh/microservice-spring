package com.anhmt.bff_service.configuration;

import com.anhmt.bff_service.properties.KafkaProperties;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class KafkaConfiguration {

    private final KafkaProperties kafkaProperties;

    @Bean
    NewTopic roomTopic() {
        return new NewTopic(kafkaProperties.getTopic().getRoom(),
                kafkaProperties.getPartition().getRoom(),
                kafkaProperties.getReplication().getRoom());
    }

    @Bean
    NewTopic bookingRoomTopic() {
        return new NewTopic(kafkaProperties.getTopic().getBookingRoom(),
                kafkaProperties.getPartition().getBookingRoom(),
                kafkaProperties.getReplication().getBookingRoom());
    }
}
