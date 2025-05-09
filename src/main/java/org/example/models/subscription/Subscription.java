package org.example.models.subscription;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

/**
 * @author mazunin-sv
 * @version 08.05.2025 13:12
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Subscription {

    @Schema(description = "Id", example = "1")
    private Long id;

    @Schema(description = "Подписка", example ="YOUTUBE_PREMIUM")
    private Subscriptions subscription;

    @Schema(description = "Дата и время окончания подписки", example ="2025-05-09T14:41:04.583Z")
    private ZonedDateTime endDateTime;

    @Schema(description = "Статус активен или нет" , example ="true")
    private boolean isActive;

}
