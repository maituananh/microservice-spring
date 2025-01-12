package com.anhmt.user_service.persistence;

import com.anhmt.user_service.domain.User;
import com.anhmt.user_service.persistence.mapper.UserEntityMapper;
import com.anhmt.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserStore {

    private final UserRepository userRepository;

    public User getByUsername(final String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> getAll() {
        return UserEntityMapper.INSTANCE.toUsers(userRepository.findAll());
    }

    public void save(final User user) {
        var userEntity = UserEntityMapper.INSTANCE.toUserEntity(user);
        userRepository.save(userEntity);
    }

    public Optional<User> getById(final UUID id) {
        var optionalUserEntity = userRepository.findById(id);

        if (optionalUserEntity.isPresent()) {
            return Optional.of(UserEntityMapper.INSTANCE.toUser(optionalUserEntity.get()));
        }
        throw new RuntimeException("user not found " + id);
    }

    public void deleteById(final UUID id) {
        userRepository.deleteById(id);
    }
}
