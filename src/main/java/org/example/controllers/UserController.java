package org.example.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.models.subscription.Subscription;
import org.example.models.subscription.SubscriptionDTO;
import org.example.models.user.User;
import org.example.models.user.UserRegisterDTO;
import org.example.models.user.UserUpdateDTO;
import org.example.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * @author mazunin-sv
 * @version 07.05.2025 18:42
 */
@AllArgsConstructor
@Tag(name = UserController.TAG)
@RestController
@RequestMapping(path = "/api/v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    public static final String TAG = "Пользователи";

    private final UserService userService;


    @PostMapping
    @Operation(summary = "Регистрация", tags = UserController.TAG, responses = {
            @ApiResponse(description = "Регистрация успешна", responseCode = "200",
                    content = @Content(schema = @Schema(implementation = User.class))),
            @ApiResponse(description = "Пользователь с таким username уже существует", responseCode = "400", content = @Content)
    })
    public ResponseEntity<Void> register(@RequestBody @Valid UserRegisterDTO dto) {
        userService.register(dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Получить пользователя", tags = UserController.TAG, responses = {
            @ApiResponse(description = "Пользователь найден", responseCode = "200",
                    content = @Content(schema = @Schema(implementation = User.class))),
            @ApiResponse(description = "Пользователь не существует", responseCode = "400", content = @Content)
    })
    public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.getUser(id));
    }

    @PutMapping(value = "/update")
    @Operation(summary = "Редактирование пользователя", tags = UserController.TAG, responses = {
            @ApiResponse(description = "Пользователь изменен", responseCode = "200",
                    content = @Content(schema = @Schema(implementation = User.class))),
            @ApiResponse(description = "Пользователь не существует", responseCode = "400", content = @Content)
    })
    public ResponseEntity<User> update(@RequestBody @Valid UserUpdateDTO dto) {
        userService.update(dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Удаление пользователя", tags = UserController.TAG, responses = {
            @ApiResponse(description = "Пользователь удален", responseCode = "200")
    })
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/add_subscription")
    @Operation(summary = "Добавление подписки", tags = UserController.TAG, responses = {
            @ApiResponse(description = "Подписка добавлена", responseCode = "200",
                    content = @Content(schema = @Schema(implementation = Subscription.class))),
            @ApiResponse(description = "Подписка не добавлена", responseCode = "400", content = @Content)
    })
    public ResponseEntity<Void> addSubscription(@RequestBody @Valid SubscriptionDTO dto) {
        userService.addSubscription(dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/subscriptions")
    @Operation(summary = "Получить список подписок пользователя", tags = UserController.TAG, responses = {
            @ApiResponse(description = "Вернул список подписок", responseCode = "200",
                    content = @Content(schema = @Schema(implementation = Subscription.class))),
            @ApiResponse(description = "Пользователь не существует", responseCode = "400", content = @Content)
    })
    public ResponseEntity<Set<Subscription>> getSubscriptions(@PathVariable("id") Long id) {

        return ResponseEntity.ok(userService.getSubscriptions(id));
    }

    @DeleteMapping(value = "/{user_id}/subscriptions/{sub_id}")
    @Operation(summary = "Подписка удалена", tags = UserController.TAG, responses = {
            @ApiResponse(description = "Подписка удалена", responseCode = "200"),
            @ApiResponse(description = "Пользователь не существует", responseCode = "400", content = @Content)
    })
    public ResponseEntity<Void> unsubscribe(@PathVariable("user_id") Long userId, @PathVariable("sub_id") Long subId) {
        userService.unsubscribe(userId, subId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
