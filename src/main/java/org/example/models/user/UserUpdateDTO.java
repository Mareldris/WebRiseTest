package org.example.models.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author mazunin-sv
 * @version 08.05.2025 15:32
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateDTO {

    @NotNull
    @Schema(description = "Id", example = "1")
    private Long id;

    @Email
    @Schema(description = "Почта", example = "exmple@mail.ru")
    private String username;

    @Schema(description = "ФИО", example = "Тестов Тест Тестовичь")
    private String fio;

    @Schema(description = "Пароль", example = "пароль")
    private String password;

    }
