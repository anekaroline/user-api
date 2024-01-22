package br.com.project.userapi.controller;

import br.com.project.userapi.controller.api.UserAPI;
import br.com.project.userapi.domain.dto.UserRequest;
import br.com.project.userapi.domain.dto.UserResponse;
import br.com.project.userapi.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class UserController implements UserAPI {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<List<UserResponse>> findAll() {
        final var result = userService.findAll();
        return ResponseEntity.ok().body(UserResponse.from(result));
    }

    @Override
    public ResponseEntity<UserResponse> findById(Long id) {
        return ResponseEntity.ok().body(UserResponse.from(userService.findById(id)));
    }

    @Override
    public ResponseEntity<UserResponse> save(UserRequest userRequest) {
        final var result = userService.save(userRequest.toDomain());
        return ResponseEntity.status(HttpStatus.CREATED).body(UserResponse.from(result));
    }

    @Override
    public ResponseEntity<UserResponse> findBycpf(UUID key, String cpf) {
        final var result = userService.findByCpf(cpf, key);
        return ResponseEntity.ok().body(UserResponse.from(result));
    }

    @Override
    public ResponseEntity<Void> deleteUser(Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<UserResponse>> queryByNameLike(String name) {
        final var result = userService.queryByNameLike(name);
        return ResponseEntity.ok().body(UserResponse.from(result));
    }
}
