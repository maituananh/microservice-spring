package com.anhmt.user_service.service.user;

import com.anhmt.user_service.api.user.req.UserCreateReq;
import com.anhmt.user_service.presenter.user.UserStore;
import com.anhmt.user_service.publish.user.UserPublish;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserStore userStore;
    private final UserPublish userPublish;

    public void save(final UserCreateReq userCreateReq) {
//        userStore.save(UserMapper.INSTANCE.toUser(userCreateReq));
        userPublish.publish(userCreateReq);
    }
}
