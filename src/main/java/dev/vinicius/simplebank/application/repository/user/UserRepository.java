package dev.vinicius.simplebank.application.repository.user;

import dev.vinicius.simplebank.domain.user.User;


import java.util.Optional;

public interface UserRepository {
    Optional<User> create(User user);
    Optional<User> findById(String userId);
    Optional<User> findByEmail(String userId);
}