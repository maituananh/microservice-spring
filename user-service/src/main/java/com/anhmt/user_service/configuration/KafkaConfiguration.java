package com.anhmt.user_service.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.anhmt.user_service.publish.user.model.TopicEnum.USER_NOTIFICATION_TOPIC;

@Configuration
public class KafkaConfiguration {

    @Bean
    NewTopic userTopic() {
        return new NewTopic(USER_NOTIFICATION_TOPIC.name(), 2, (short) 1);
    }

//    @Bean
//    NewTopic userTopic() {
//        return new NewTopic(USER_NOTIFICATION_TOPIC, 2, (short) 1);
//    }
}
