package com.anhmt.user_service.properties;

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
    private KafkaReplication replication;
    private KafkaPartition partition;

    @Setter
    @Getter
    public static class KafkaTopic {
        private String user;
    }

    @Setter
    @Getter
    public static class KafkaReplication {
        private short user;
    }

    @Setter
    @Getter
    public static class KafkaPartition {
        private int user;
    }
}
