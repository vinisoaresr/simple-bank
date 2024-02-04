package dev.vinicius.simplebank.domain.account.transaction;

import dev.vinicius.simplebank.domain.account.BankAccount;

public record Deposit(BankAccount payer, BankAccount payee, double value,
                      String description) implements Transaction {
  
  public static Deposit create(BankAccount payer, BankAccount payee, double value,
      String description) {
    return new Deposit(payer, payee, value, description);
  }

}
