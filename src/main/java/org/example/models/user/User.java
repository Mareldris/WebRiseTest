package org.example.models.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.models.subscription.Subscription;

import java.util.Set;

/**
 * @author mazunin-sv
 * @version 08.05.2025 13:04
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Schema(description = "Id", example = "1")
    private Long id;

    @Schema(description = "Почта", example = "exmple@mail.ru")
    private String username;

    @Schema(description = "ФИО", example = "Тестов Тест Тестовичь")
    private String fio;

    @Schema(description = "Подписки", example = "YouTube Premium, VK Музыка, Яндекс.Плюс, Netflix")
    private Set<Subscription> subscriptions;
}
