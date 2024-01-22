package br.com.project.userapi.domain.dto;

import br.com.project.userapi.domain.models.User;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public record UserResponse (
        UUID key,
        @NotBlank
        String name,
        @NotBlank
        String cpf,
        String address,
        @NotBlank
        String email,
        String phone,
        LocalDateTime createdAt

) {

        public static UserResponse from(User user) {
            return new UserResponse(
                    user.getKey(),
                    user.getName(),
                    user.getCpf(),
                    user.getAddress(),
                    user.getEmail(),
                    user.getPhone(),
                    user.getCreatedAt()
            );
        }

    public static List<UserResponse> from(List<User> userList) {
        return userList.stream()
                .map(UserResponse::from)
                .collect(Collectors.toList());
    }
}
