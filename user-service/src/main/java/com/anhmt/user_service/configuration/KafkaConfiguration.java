package com.anhmt.user_service.configuration;

import com.anhmt.user_service.properties.KafkaProperties;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class KafkaConfiguration {

    private final KafkaProperties kafkaProperties;

    @Bean
    NewTopic userTopic() {
        return new NewTopic(kafkaProperties.getTopic().getUser(),
                kafkaProperties.getPartition().getUser(),
                kafkaProperties.getReplication().getUser());
    }
}
