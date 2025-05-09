package org.example.models.subscription;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author mazunin-sv
 * @version 08.05.2025 22:24
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionDTO {

    @NotNull
    @Schema(description = "Id пользователя", example = "1")
    private Long userId;

    @NotNull
    @Schema(description = "Подписка", example = "YOUTUBE_PREMIUM")
    private Subscriptions subscription;

    @NotNull
    @Schema(description = "Количество месяцев", example = "12")
    private Integer month;

}
