package br.com.project.userapi.domain.dto;

import br.com.project.userapi.domain.models.User;
import jakarta.validation.constraints.NotBlank;

public record UserRequest(
        @NotBlank
        String name,
        @NotBlank
        String cpf,
        String address,
        @NotBlank
        String email,
        String phone

) {

    public User toDomain(){
        return new User(
                null,
                null,
                this.cpf,
                this.name,
                this.address,
                this.email,
                this.phone,
                null,
                null
        );
    }

}
