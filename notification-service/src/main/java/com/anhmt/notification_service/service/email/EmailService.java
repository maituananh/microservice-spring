package com.anhmt.notification_service.service.email;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailService {

    public void sendEmail(final String to) {
        log.info("Sending email to {}", to);
    }
}
