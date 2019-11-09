package com.project2.creditcard.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class PaymentInfo {
    private Integer id;
    public  boolean preferred = false;
    private String bankNumber;
    private String routingNumber;
    private String creditCardNumber;
    private String securityNumber;
    private String expirationDate;
    private String userName;
    private PaymentMethod paymentMethod;
    private Double amount;
}

