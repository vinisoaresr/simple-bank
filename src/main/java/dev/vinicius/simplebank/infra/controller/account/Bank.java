package dev.vinicius.simplebank.infra.controller.account;

import dev.vinicius.simplebank.application.usecases.account.CreateAgency;
import dev.vinicius.simplebank.application.usecases.account.CreateBank;
import dev.vinicius.simplebank.application.usecases.account.CreateBank.Input;
import dev.vinicius.simplebank.infra.dtos.CreateAgencyDto;
import dev.vinicius.simplebank.infra.dtos.CreateBankDto;
import java.net.URI;
import java.util.Objects;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank")
public class Bank {

  private final CreateBank createBank;
  private final CreateAgency createAgency;

  public Bank(CreateBank createBank, CreateAgency createAgency) {
    this.createBank = Objects.requireNonNull(createBank);
    this.createAgency = Objects.requireNonNull(createAgency);
  }

  @PostMapping()
  public ResponseEntity<?> create(@RequestBody CreateBankDto body) {
    final var input = new Input(body.name(), body.description());
    final var output = createBank.execute(input);

    return ResponseEntity.created(URI.create("/bank/" + output.id())).body(output);
  }

  @PostMapping("/agency")
  public ResponseEntity<?> createAgency(@RequestBody CreateAgencyDto body) {
    final var input = new CreateAgency.Input(body.name(), body.agencyNumber(), body.bankId());
    final var output = createAgency.execute(input);

    return ResponseEntity.created(URI.create("/bank/agency/" + output.id())).body(output);
  }

  @PostMapping("/account")
  public ResponseEntity<?> createAccount() {
    return ResponseEntity.ok().build();

  }

  @PostMapping("/transaction/deposit")
  public ResponseEntity<?> deposit() {
    return ResponseEntity.ok().build();

  }

  @PostMapping("/transaction/withdraw")
  public ResponseEntity<?> withdraw() {
    return ResponseEntity.ok().build();

  }

  @PostMapping("/transaction/transfer")
  public ResponseEntity<?> transfer() {
    return ResponseEntity.ok().build();

  }

}