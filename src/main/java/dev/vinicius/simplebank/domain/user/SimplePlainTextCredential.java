package dev.vinicius.simplebank.domain.user;

public record SimplePlainTextCredential(String value) implements Credential {

    public static SimplePlainTextCredential create(final String plainText) {
        return new SimplePlainTextCredential(plainText);
    }

    @Override
    public boolean validate(String password) {
        return value().equals(password);
    }
}
