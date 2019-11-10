package edu.mum.cs.auth.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class PaymentInfo {
    public  boolean preferred = false;
    private String bankNumber;
    private String routingNumber;
    private String creditCardNumber;
    private String securityNumber;
    private String expirationDate;
    private String userName;
    private PaymentMethod paymentMethod;
    private String email;
}

enum PaymentMethod {
    CREDITCARD,
    BANKACCOUNT,
    PAYPAL
}
