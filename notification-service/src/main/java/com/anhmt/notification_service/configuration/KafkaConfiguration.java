package com.anhmt.notification_service.configuration;

import com.anhmt.notification_service.properties.KafkaProperties;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.util.backoff.FixedBackOff;

@Configuration
@RequiredArgsConstructor
public class KafkaConfiguration {

    private final KafkaProperties kafkaProperties;

    @Bean
    public JsonMessageConverter jsonMessageConverter() {
        return new JsonMessageConverter();
    }

    @Bean
    NewTopic notificationDLTTopic() {
        return new NewTopic(kafkaProperties.getTopic().getUserDlt(),
                kafkaProperties.getPartition().getUserDlt(),
                kafkaProperties.getReplication().getUserDlt());
    }

    @Bean
    DefaultErrorHandler errorHandler(KafkaOperations<String, Object> kafkaOperations) {
        return new DefaultErrorHandler(new DeadLetterPublishingRecoverer(
                kafkaOperations), new FixedBackOff(1000L, 2));
    }
}
