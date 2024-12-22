package com.anhmt.notification_service.subscriber.user;

import com.anhmt.notification_service.service.email.EmailService;
import com.anhmt.notification_service.subscriber.user.model.UserSubscriberDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserSubscriber {

    private final EmailService emailService;

    @KafkaListener(groupId = "${spring.kafka.group.user}", topics = "${spring.kafka.topic.user}")
    public void listen(final UserSubscriberDTO userSubscriberDTO) {
        log.info("Received user subscriber: {}", userSubscriberDTO);
        emailService.sendEmail(null);
    }
}
