package com.anhmt.booking_service.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "spring.kafka")
public class KafkaProperties {

    private KafkaTopic topic;

    @Setter
    @Getter
    public static class KafkaTopic {
        private String room;
        private String bookingRoom;
        private String bookingRoomReply;
    }
}
