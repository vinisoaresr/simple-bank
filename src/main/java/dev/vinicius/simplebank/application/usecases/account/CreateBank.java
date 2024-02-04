package dev.vinicius.simplebank.application.usecases.account;

import dev.vinicius.simplebank.application.repository.bank.BankRepository;
import dev.vinicius.simplebank.application.usecases.UseCase;
import dev.vinicius.simplebank.domain.account.Bank;
import java.util.Objects;
import org.springframework.stereotype.Component;

@Component
public class CreateBank implements UseCase<CreateBank.Input, CreateBank.Output> {

  final BankRepository repository;

  public CreateBank(BankRepository repository) {
    this.repository = Objects.requireNonNull(repository);
  }

  @Override
  public Output execute(Input input) {

    final var bank = repository.create(Bank.create(
            input.name,
            input.description
        )
    );

    if (bank.isEmpty()) {
      throw new RuntimeException("Error on create bank");
    }

    return new Output(
        bank.get().id(),
        bank.get().name(),
        bank.get().description()
    );
  }

  public record Input(String name, String description) {

  }

  public record Output(String id, String name, String description) {

  }
}
