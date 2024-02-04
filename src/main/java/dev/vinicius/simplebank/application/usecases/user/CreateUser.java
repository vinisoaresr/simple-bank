package dev.vinicius.simplebank.application.usecases.user;

import dev.vinicius.simplebank.application.repository.user.UserRepository;
import dev.vinicius.simplebank.application.usecases.UseCase;
import dev.vinicius.simplebank.domain.user.User;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CreateUser implements UseCase<CreateUser.Input, CreateUser.Output> {

  final UserRepository repository;

  public CreateUser(UserRepository repository) {
    this.repository = Objects.requireNonNull(repository);
  }

  public Output execute(Input input) {
    if (this.existsUser(input)) {
      throw new ValidationException("User already exists!");
    }

    final var user = repository.create(User.create(input.name(), input.email(), input.password()));

    if (user.isEmpty()) {
      throw new RuntimeException("User already exists!");
    }

    return new Output(user.get().id(), user.get().name(), user.get().email());
  }

  private boolean existsUser(Input input) {
    final var user = this.repository.findByEmail(input.email());

    return user.isPresent();
  }

  public record Input(String name, String email, String password) {

  }

  public record Output(String id, String name, String email) {

  }
}