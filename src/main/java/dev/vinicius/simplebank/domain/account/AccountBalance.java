package dev.vinicius.simplebank.domain.account;

import dev.vinicius.simplebank.infra.utils.IdGenerator;
import java.time.LocalDateTime;

public record AccountBalance(String id, double value, BankAccount bankAccount,
                             LocalDateTime createdAt) {

  public AccountBalance {
    if (value < 0) {
      throw new IllegalArgumentException("Balance cannot be negative");
    }
  }

  public static AccountBalance create(double value) {
    return new AccountBalance(IdGenerator.next(), value, null, LocalDateTime.now());
  }

}
