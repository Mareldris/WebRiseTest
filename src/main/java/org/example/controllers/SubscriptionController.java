package org.example.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.example.models.subscription.SubscriptionTopResponseDTO;
import org.example.models.user.User;
import org.example.services.SubscriptionService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * @author mazunin-sv
 * @version 07.05.2025 18:42
 */
@AllArgsConstructor
@Tag(name = SubscriptionController.TAG)
@RestController
@RequestMapping(path = "/api/v1/subscriptions", produces = MediaType.APPLICATION_JSON_VALUE)
public class SubscriptionController {

    public static final String TAG = "Подписки";

    private final SubscriptionService subscriptionService;


    @GetMapping(value = "/top")
    @Operation(summary = "Получить топ 3 подписок", tags = SubscriptionController.TAG, responses = {
            @ApiResponse(description = "Вернул топ 3 подписки", responseCode = "200",
                    content = @Content(schema = @Schema(implementation = User.class)))
    })
    public ResponseEntity<Set<SubscriptionTopResponseDTO>> getSubscriptions() {

        return ResponseEntity.ok(subscriptionService.getTopThree());
    }

}
