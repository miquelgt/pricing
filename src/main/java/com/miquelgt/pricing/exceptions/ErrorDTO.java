package com.miquelgt.pricing.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;

@Data
@NoArgsConstructor
public class ErrorDTO {
    private String message;
    private long   timestamp;
    private String path;
    private String requestId;
    private int    status;

    public ErrorDTO(String message, ServerHttpRequest request, HttpStatus status) {
        this.timestamp = System.currentTimeMillis();
        this.message   = message;
        this.path      = request.getPath().toString();
        this.requestId = request.getId();
        this.status    = status.value();
    }
}
