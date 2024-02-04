package dev.vinicius.simplebank.domain.user;

public sealed interface Credential permits SimplePlainTextCredential {

  String value();

  static Credential create(String plainText) {
    throw new RuntimeException();
  }

  boolean validate(String password);
}
