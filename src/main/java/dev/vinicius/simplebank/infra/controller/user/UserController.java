package dev.vinicius.simplebank.infra.controller.user;

import dev.vinicius.simplebank.application.usecases.user.CreateUser;
import dev.vinicius.simplebank.infra.dtos.CreateUserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Objects;

@RestController
@RequestMapping("user")
public class UserController {

    private final CreateUser service;

    public UserController( final CreateUser service ) {
        this.service = Objects.requireNonNull(service);
    }

    @PostMapping()
    public ResponseEntity<?> create( @RequestBody CreateUserDto input ) {
        var body = service.execute(new CreateUser.Input(input.name(), input.email(), input.password()));

        return ResponseEntity.created(URI.create("/user/" + body.id())).body(body);
    }
}
