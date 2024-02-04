package dev.vinicius.simplebank.domain.user;

import dev.vinicius.simplebank.infra.utils.IdGenerator;


public record User(String id, String name, String email, Credential credential) {

    public static User create( String name, String email, String password ) {
        return new User(IdGenerator.next(), name, email, SimplePlainTextCredential.create(password));
    }
}
