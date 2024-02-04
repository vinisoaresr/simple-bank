package dev.vinicius.simplebank.infra.repository;

import dev.vinicius.simplebank.application.repository.user.UserRepository;
import dev.vinicius.simplebank.domain.user.User;
import org.springframework.stereotype.Component;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class InMemoryUserRepository implements UserRepository {

  private final Map<String, User> table;
  private final Map<String, User> emailIndex;

  public InMemoryUserRepository() {
    this.table = new ConcurrentHashMap<>();
    this.emailIndex = new ConcurrentHashMap<>();
  }

  @Override
  public Optional<User> create(User user) {
    if (this.existsRow(user)) {
      return Optional.empty();
    }

    table.put(user.id(), user);

    emailIndex.put(user.email(), user);

    return Optional.ofNullable(user);
  }

  private boolean existsRow(User user) {
    return this.findByEmail(user.email()).isPresent();
  }

  @Override
  public Optional<User> findById(String userId) {
    return Optional.ofNullable(this.table.get(userId));
  }

  @Override
  public Optional<User> findByEmail(String email) {
    return Optional.ofNullable(this.emailIndex.get(email));
  }
}
