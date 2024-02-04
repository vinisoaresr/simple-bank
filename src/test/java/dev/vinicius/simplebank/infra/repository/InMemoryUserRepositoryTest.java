package dev.vinicius.simplebank.infra.repository;

import dev.vinicius.simplebank.application.repository.user.UserRepository;
import dev.vinicius.simplebank.domain.user.SimplePlainTextCredential;
import dev.vinicius.simplebank.domain.user.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InMemoryUserRepositoryTest {

  final UserRepository inMemoRepo = new InMemoryUserRepository();

  @Test
  void shouldBeCreateOnceUser() {
    // Arrange
    final var expectedUser = new User("1", "test", "teste@teste.com",
        new SimplePlainTextCredential("12345"));

    // Act
    inMemoRepo.create(expectedUser);

    // Assert
    Assertions.assertTrue(inMemoRepo.findById("1").isPresent());
  }

  @Test
  void shouldBeFindOnceUserByEmail() {
    // Arrange
    final var expectedUser = new User("1", "test", "duplicated@email.com",
        new SimplePlainTextCredential("12345"));
    final var unexpectedUser = new User("2", "test2", "duplicated@email.com",
        new SimplePlainTextCredential("12345"));

    // Act
    inMemoRepo.create(expectedUser);
    inMemoRepo.create(unexpectedUser);

    // Assert
    Assertions.assertTrue(inMemoRepo.findByEmail("duplicated@email.com").isPresent());
    Assertions.assertFalse(inMemoRepo.findById("2").isPresent());
  }
}