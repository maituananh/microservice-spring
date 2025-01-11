package com.anhmt.user_service.repository;

import com.anhmt.user_service.domain.User;
import com.anhmt.user_service.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    User findByUsername(String username);
}
