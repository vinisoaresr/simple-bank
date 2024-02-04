package dev.vinicius.simplebank.application.repository.bank;

import dev.vinicius.simplebank.domain.account.Agency;
import java.util.Optional;


public interface AgencyRepository {

  Optional<Agency> create(Agency user);

  Optional<Agency> findById(String userId);
}