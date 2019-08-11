package com.market.api.exception.responsemodel;

import org.springframework.stereotype.Component;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Map;

@Component
public class ResponseModelUserAlreadyExists {

    private String message;
    private LocalDateTime timestamp;
    private URI uri;
    private Map<String, String> credentials;

    public ResponseModelUserAlreadyExists(String message, LocalDateTime timestamp, URI uri, Map<String, String> credentials) {
        this.message = message;
        this.timestamp = timestamp;
        this.uri = uri;
        this.credentials = credentials;
    }

    public ResponseModelUserAlreadyExists() {
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

    public Map<String, String> getCredentials() {
        return credentials;
    }

    public void setCredentials(Map<String, String> credentials) {
        this.credentials = credentials;
    }
}
