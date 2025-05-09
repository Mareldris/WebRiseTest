package org.example.models.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author mazunin-sv
 * @version 08.05.2025 13:14
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterDTO {

    @Email
    @Schema(description = "Почта", example = "exmple@mail.ru")
    private String username;

    @NotBlank
    @Schema(description = "Пароль", example = "пароль")
    private String password;

    @Schema(description = "ФИО", example = "Тестов Тест Тестовичь")
    private String fio;
}
