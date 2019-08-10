package com.market.api.entity.util;

public enum Status {

    NEW("NEW"),
    PUBLISHED("PUBLISHED");

    private String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
