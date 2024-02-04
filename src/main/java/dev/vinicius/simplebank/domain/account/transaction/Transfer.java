package dev.vinicius.simplebank.domain.account.transaction;

import dev.vinicius.simplebank.domain.account.BankAccount;

public record Transfer(BankAccount payer, BankAccount payee, double value,
                       String description) implements Transaction {

  public static Transfer create(BankAccount payer, BankAccount payee, double value,
      String description) {
    return new Transfer(payer, payee, value, description);
  }

}
