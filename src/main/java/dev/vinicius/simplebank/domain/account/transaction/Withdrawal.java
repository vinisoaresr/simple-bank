package dev.vinicius.simplebank.domain.account.transaction;

import dev.vinicius.simplebank.domain.account.BankAccount;

public record Withdrawal(BankAccount payer, BankAccount payee, double value,
                         String description) implements Transaction {


  public static Withdrawal create(BankAccount payer, BankAccount payee, double value,
      String description) {
    return new Withdrawal(payer, payee, value, description);
  }
}
