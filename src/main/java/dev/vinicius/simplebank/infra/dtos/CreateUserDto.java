package dev.vinicius.simplebank.infra.dtos;

public record CreateUserDto(String name, String email, String password) {
}
