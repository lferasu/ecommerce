package com.project2.payment.controller.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Reciept {
    private String payer;
    private Double amount;
    private PaymentMethod paymentMethod;
    private LocalDate paymentDate;
}
enum PaymentMethod {
    CREDITCARD,
    BANKACCOUNT,
    PAYPAL
}
