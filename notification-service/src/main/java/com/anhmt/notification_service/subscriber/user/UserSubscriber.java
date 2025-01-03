package com.anhmt.notification_service.subscriber.user;

import com.anhmt.notification_service.service.email.EmailService;
import com.anhmt.notification_service.subscriber.user.model.UserSubscriberDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.retrytopic.DltStrategy;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserSubscriber {

    private final EmailService emailService;

    @RetryableTopic(
            attempts = "4",
            backoff = @Backoff(delay = 1000, multiplier = 2),
            autoCreateTopics = "true",
            dltStrategy = DltStrategy.FAIL_ON_ERROR,
            include = RuntimeException.class
    )
    @KafkaListener(groupId = "${spring.kafka.group.user}", topics = "${spring.kafka.topic.user}")
    public void listen(final UserSubscriberDTO userSubscriberDTO) {
        log.info("Received user subscriber: {}", userSubscriberDTO.toString());
        emailService.sendEmail(null);
    }

    @DltHandler
    public void dltHandle(@Payload String message) {
        log.info("DLT Message: {}", message);
    }
}
