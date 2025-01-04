package com.anhmt.user_service.publisher.user;

import com.anhmt.user_service.command.api.user.req.UserCreateReq;
import com.anhmt.user_service.properties.KafkaProperties;
import com.anhmt.user_service.publisher.user.mapper.UserPublisherMapper;
import com.anhmt.user_service.publisher.user.model.UserPublisherDTO;
import com.anhmt.user_service.publisher.user.model.UserPublisherEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserPublisher {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final KafkaProperties kafkaProperties;

    public void publish(final UserCreateReq userCreateReq) {
        UserPublisherDTO userPublisherDTO = UserPublisherMapper.INSTANCE.toUserPublisher(userCreateReq,
                UserPublisherEnum.CREATE_USER);

        kafkaTemplate.send(kafkaProperties.getTopic().getUser(), userPublisherDTO)
                .whenCompleteAsync((result, ex) -> {
                    if (ex != null) {
                        log.error(ex.getMessage());
                        return;
                    }

                    log.info("Completed: {}", result.getProducerRecord().value().toString());
                });
    }
}
