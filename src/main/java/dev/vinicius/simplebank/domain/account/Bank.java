package dev.vinicius.simplebank.domain.account;

import dev.vinicius.simplebank.infra.utils.IdGenerator;

public record Bank(String id, String name, String description) {

  public Bank {
    if (name == null || name.isBlank()) {
      throw new IllegalArgumentException("Bank name cannot be null or empty");
    }
  }

  public static Bank create(String name, String description) {
    return new Bank(IdGenerator.next(), name, description);
  }
}
