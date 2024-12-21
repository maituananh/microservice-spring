package com.anhmt.user_service.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfiguration {

    public static final String USER_NOTIFICATION_TOPIC = "user-notification-topic";

    @Bean
    NewTopic userTopic() {
        return new NewTopic(USER_NOTIFICATION_TOPIC, 2, (short) 1);
    }

//    @Bean
//    NewTopic userTopic() {
//        return new NewTopic(USER_NOTIFICATION_TOPIC, 2, (short) 1);
//    }
}
