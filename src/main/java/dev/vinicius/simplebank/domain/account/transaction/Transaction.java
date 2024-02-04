package dev.vinicius.simplebank.domain.account.transaction;

import dev.vinicius.simplebank.domain.account.BankAccount;

public sealed interface Transaction permits Transfer, Deposit, Withdrawal {

  BankAccount payer();

  BankAccount payee();

  double value();

  String description();

  static Transaction create(BankAccount payer, BankAccount payee, double value,
      String description) {
    throw new UnsupportedOperationException("Not implemented");
  }

  ;

}
