package com.anhmt.user_service.publish.user;

import com.anhmt.user_service.api.user.req.UserCreateReq;
import com.anhmt.user_service.publish.user.mapper.UserPublisherMapper;
import com.anhmt.user_service.publish.user.model.UserPublisher;
import com.anhmt.user_service.publish.user.model.UserPublisherEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static com.anhmt.user_service.publish.user.model.TopicEnum.USER_NOTIFICATION_TOPIC;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserPublish {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void publish(final UserCreateReq userCreateReq) {
        UserPublisher userPublisher = UserPublisherMapper.INSTANCE.toUserPublisher(userCreateReq, UserPublisherEnum.CREATE_USER);

        kafkaTemplate.send(USER_NOTIFICATION_TOPIC.name(), userPublisher);

        log.info("Publishing user {}", userPublisher);
    }
}
