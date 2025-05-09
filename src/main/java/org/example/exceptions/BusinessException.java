package org.example.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

/**
 * @author mazunin-sv
 * @version 08.05.2025 13:23
 */
@Getter
public class BusinessException  extends RuntimeException{

    private final ZonedDateTime timestamp = ZonedDateTime.now();
    private final String businessMessage;
    private final HttpStatus status;
    private final String code;

    public BusinessException(String businessMessage, HttpStatus status, String code)
    {
        this.businessMessage = businessMessage;
        this.status = status;
        this.code = code;
    }
}
