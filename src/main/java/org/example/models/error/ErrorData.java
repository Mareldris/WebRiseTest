package org.example.models.error;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.ZonedDateTime;

/**
 * @author mazunin-sv
 * @version 09.05.2025 17:36
 */

@Schema(name = "ERROR MODEL")
@Getter
@ToString
@Builder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorData
{

    @Schema(description = "Дата/время ошибки в UTC", implementation = String.class)
    private ZonedDateTime timestamp;
    @Schema(description = "HTTP STATUS")
    private Integer status;
    @Schema(description = "Внутренний код ошибки")
    private String code;
    @Schema(description = "Полный текст ошибки")
    private Object message;
    @Schema(description = "HTTP PATH")
    private String path;
}

