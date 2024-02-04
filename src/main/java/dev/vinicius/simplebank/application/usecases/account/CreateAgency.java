package dev.vinicius.simplebank.application.usecases.account;

import dev.vinicius.simplebank.application.repository.bank.AgencyRepository;
import dev.vinicius.simplebank.application.repository.bank.BankRepository;
import dev.vinicius.simplebank.application.usecases.UseCase;
import dev.vinicius.simplebank.domain.account.Agency;
import dev.vinicius.simplebank.domain.account.Bank;
import java.util.Objects;
import org.springframework.stereotype.Component;

@Component
public class CreateAgency implements UseCase<CreateAgency.Input, CreateAgency.Output> {

  final AgencyRepository repository;
  final BankRepository bankRepository;

  public CreateAgency(AgencyRepository repository, BankRepository bankRepository) {
    this.repository = Objects.requireNonNull(repository);
    this.bankRepository = Objects.requireNonNull(bankRepository);
  }

  @Override
  public Output execute(Input input) {

    final var bank = bankRepository.findById(input.bankId()).orElseThrow(
        () -> new RuntimeException("Bank not found")
    );

    final var agency = repository.create(Agency.create(
            input.name(),
            input.agencyNumber(),
            bank
        )
    );

    if (agency.isEmpty()) {
      throw new RuntimeException("Error on create agency");
    }

    return new Output(
        agency.get().id(),
        agency.get().name(),
        agency.get().agencyNumber(),
        agency.get().bank()

    );
  }

  public record Input(String name, String agencyNumber, String bankId) {

  }

  public record Output(String id, String name, String agencyNumber, Bank bank) {

  }
}
