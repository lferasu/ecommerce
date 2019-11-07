package com.project2.user.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class PaymentInfo {
    @Id
    @GeneratedValue
    private Integer id;
    public  boolean preferred = false;
    private String bankNumber;
    private String routingNumber;
    private String creditCardNumber;
    private String securityNumber;
    private String expirationDate;
    private String userName;
    private PaymentMethod paymentMethod;
}

enum PaymentMethod {
    CREDITCARD,
    BANKACCOUNT,
    PAYPAL
}
