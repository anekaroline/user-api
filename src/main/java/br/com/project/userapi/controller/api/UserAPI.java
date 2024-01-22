package br.com.project.userapi.controller.api;

import br.com.project.userapi.domain.dto.UserRequest;
import br.com.project.userapi.domain.dto.UserResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/users")
public interface UserAPI {

    @GetMapping
    ResponseEntity<List<UserResponse>> findAll();

    @GetMapping("/{id}")
    ResponseEntity<UserResponse> findById(@PathVariable Long id);

    @PostMapping
    ResponseEntity<UserResponse> save(@RequestBody @Valid UserRequest userRequest);

    @GetMapping("/{cpf}/cpf")
    ResponseEntity<UserResponse> findBycpf(@RequestParam(name="key") UUID key, @PathVariable String cpf);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteUser(@PathVariable Long id);

    @GetMapping("/search")
    ResponseEntity<List<UserResponse>> queryByNameLike(@RequestParam(name = "name") String name);



}
