package dev.vinicius.simplebank.domain.account;

import dev.vinicius.simplebank.domain.user.User;
import dev.vinicius.simplebank.infra.utils.IdGenerator;

public record BankAccount(String id, String accountNumber, User user, AccountBalance balance,
                          Agency agency) {

  public BankAccount {
    if (balance.value() < 0) {
      throw new IllegalArgumentException("Balance cannot be negative");
    }
  }

  public static BankAccount create(String accountNumber, double initialBalance, User user,
      Agency agency) {
    final var balance = AccountBalance.create(initialBalance);

    return new BankAccount(IdGenerator.next(), accountNumber, user, balance, agency);
  }
}
