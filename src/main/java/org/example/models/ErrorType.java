package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author mazunin-sv
 * @version 08.05.2025 13:21
 */
@AllArgsConstructor
@Getter
public enum ErrorType {

    USER_IS_FOUND("Пользователь %s уже существует"),
    USER_IS_NOT_FOUND("Пользователь %s не найден"),
    SUBSCRIPTION_NOT_FOUND("Подписка %d у пользователя не найдена");


    private final String message;
}
