package org.example.configuration;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.example.exceptions.BusinessException;
import org.example.models.error.ErrorData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author mazunin-sv
 * @version 09.05.2025 17:35
 */
@Slf4j
@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<ErrorData> businessExceptionHandle(BusinessException ex, HttpServletRequest request)
    {
        ErrorData errorData = ErrorData.builder()
                .message(ex.getBusinessMessage())
                .status(ex.getStatus() != null ? ex.getStatus().value() : null)
                .code(ex.getCode())
                .timestamp(ex.getTimestamp())
                .path(request.getRequestURI())
                .build();

        log.error("error data: {};BusinessException: {};", errorData, ex.getBusinessMessage());

        return ResponseEntity.status(ex.getStatus())
                .body(errorData);
    }
}
