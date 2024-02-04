package dev.vinicius.simplebank.infra.repository;

import dev.vinicius.simplebank.application.repository.bank.AgencyRepository;
import dev.vinicius.simplebank.domain.account.Agency;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Component;

@Component
public class InMemoryAgencyRepository implements AgencyRepository {

  private final Map<String, Agency> table;

  public InMemoryAgencyRepository() {
    this.table = new ConcurrentHashMap<>();
  }

  @Override
  public Optional<Agency> create(Agency Agency) {

    table.put(Agency.id(), Agency);

    return Optional.of(Agency);
  }

  @Override
  public Optional<Agency> findById(String AgencyId) {
    return Optional.ofNullable(this.table.get(AgencyId));
  }
}
