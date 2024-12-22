package com.anhmt.notification_service.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "spring.kafka")
public class KafkaProperties {

    private KafkaTopics topic;
    private KafkaGroups group;

    @Setter
    @Getter
    public static class KafkaTopics {
        private String user;
    }

    @Setter
    @Getter
    public static class KafkaGroups {
        private String user;
    }
}
