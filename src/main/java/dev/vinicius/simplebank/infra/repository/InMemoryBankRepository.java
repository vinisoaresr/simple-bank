package dev.vinicius.simplebank.infra.repository;

import dev.vinicius.simplebank.application.repository.bank.BankRepository;
import dev.vinicius.simplebank.domain.account.Bank;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Component;

@Component
public class InMemoryBankRepository implements BankRepository {

  private final Map<String, Bank> table;

  public InMemoryBankRepository() {
    this.table = new ConcurrentHashMap<>();
  }

  @Override
  public Optional<Bank> create(Bank Bank) {

    table.put(Bank.id(), Bank);

    return Optional.of(Bank);
  }

  @Override
  public Optional<Bank> findById(String bankId) {
    if (bankId == null || !this.table.containsKey(bankId)) {
      return Optional.empty();
    }

    return Optional.ofNullable(this.table.get(bankId));
  }
}
