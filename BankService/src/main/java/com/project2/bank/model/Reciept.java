package com.project2.bank.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Reciept {
    private String payer;
    private Double amount;
    private PaymentMethod paymentMethod;
    private LocalDate paymentDate;
}

