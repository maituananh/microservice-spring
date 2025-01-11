package com.anhmt.user_service.repository;

import com.anhmt.user_service.presenter.entities.UserTokenEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TokenRepository extends CrudRepository<UserTokenEntity, UUID> {
}
