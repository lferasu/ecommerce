package com.project2.productservice.models;

import lombok.Data;

@Data
public class ErrorMessage {
    private String errorMessage;
    public ErrorMessage(String msg) {
        this.errorMessage = msg;
    }
}
