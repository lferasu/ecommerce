package com.project2.payment.controller.model;

import lombok.Data;

@Data
public class ErrorMessage {
    private String errorMessage;
    public ErrorMessage(String msg) {
        this.errorMessage = msg;
    }
}
