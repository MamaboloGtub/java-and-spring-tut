package com.mamabologtub.library_system.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

/**
 * @Author Tshepo M Mahudu on Sep 7, 2025.
 */
@Data
@Builder
public class ErrorResponse {
    private String message;
    @Schema(description = "Is a code based on HTTP status codes")
    private Integer code;
    private String source;
}
