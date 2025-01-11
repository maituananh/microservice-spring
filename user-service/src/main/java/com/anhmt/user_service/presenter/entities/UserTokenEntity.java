package com.anhmt.user_service.presenter.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import java.util.UUID;

@RedisHash("users-token")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserTokenEntity {
    private UUID id;
    private UUID userId;
    private String username;
    private String accessToken;
    private String refreshToken;
}
