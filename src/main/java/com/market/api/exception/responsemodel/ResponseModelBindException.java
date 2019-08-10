package com.market.api.exception.responsemodel;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ResponseModelBindException{

    private List<ErrorDetails> errorDetailsList;

    public ResponseModelBindException() {
        errorDetailsList = new ArrayList<>();
    }

    public ResponseModelBindException(List<ErrorDetails> errorDetailsList) {
        this.errorDetailsList = errorDetailsList;
    }

    private static class ErrorDetails{
        private String field;
        private String defaultMessage;

        public ErrorDetails() {
        }

        ErrorDetails(String field, String defaultMessage) {
            this.field = field;
            this.defaultMessage = defaultMessage;
        }

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public String getDefaultMessage() {
            return defaultMessage;
        }

        public void setDefaultMessage(String defaultMessage) {
            this.defaultMessage = defaultMessage;
        }
    }

    public void addErrorDetails(String field, String message)
    {
        this.errorDetailsList.add(new ErrorDetails(field, message));
    }

    public List<ErrorDetails> getErrorDetailsList()
    {
        return this.errorDetailsList;
    }

}
