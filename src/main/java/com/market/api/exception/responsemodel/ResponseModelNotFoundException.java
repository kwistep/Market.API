package com.market.api.exception.responsemodel;

import org.springframework.stereotype.Component;

import java.net.URI;
import java.time.LocalDateTime;

@Component
public class ResponseModelNotFoundException {

    private String message;
    private LocalDateTime timestamp;
    private URI uri;

    public ResponseModelNotFoundException() {
    }

    public ResponseModelNotFoundException(String message, LocalDateTime timestamp, URI uri) {
        this.message = message;
        this.timestamp = timestamp;
        this.uri = uri;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public URI getUri() {
        return uri;
    }

    public void setUri(URI uri) {
        this.uri = uri;
    }
}
