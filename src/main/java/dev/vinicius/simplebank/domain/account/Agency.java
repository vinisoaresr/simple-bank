package dev.vinicius.simplebank.domain.account;

import dev.vinicius.simplebank.infra.utils.IdGenerator;

public record Agency(String id, String name, String agencyNumber, Bank bank) {

  public static Agency create(String name, String agencyNumber, Bank bank) {
    return new Agency(IdGenerator.next(), name, agencyNumber, bank);
  }

}
