package org.example.models.subscription;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author mazunin-sv
 * @version 09.05.2025 1:40
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionTopResponseDTO {

    @Schema(description = "Подписка", example = "NETFLIX")
    private String subscription;

    @Schema(description = "Количество подписчиков", example = "222")
    private Long countSubscribers;
}
