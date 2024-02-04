package dev.vinicius.simplebank.domain.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimplePlainTextCredentialTest {

    @Test
    public void shouldBeEqual() {
        final var expectedPassword = "12345";

        final var password = new SimplePlainTextCredential("12345");

        Assertions.assertTrue(password.validate(expectedPassword));
    }

}