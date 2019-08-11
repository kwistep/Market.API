package com.market.api.entity.util;

public enum ProductCondition {
    NEW("NEW"),
    USED("USED");

    ProductCondition() {
    }

    ProductCondition(String condition) {
        this.condition = condition;
    }

    private String condition;


    public String getCondition() {
        return condition;
    }
}
