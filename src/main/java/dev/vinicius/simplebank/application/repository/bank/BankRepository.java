package dev.vinicius.simplebank.application.repository.bank;

import dev.vinicius.simplebank.domain.account.Bank;
import java.util.Optional;

public interface BankRepository {

  Optional<Bank> create(Bank user);

  Optional<Bank> findById(String userId);
}