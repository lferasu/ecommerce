package com.project2.payment.controller.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Reciept {
    @Id
    @GeneratedValue
    Integer id;
    private String payer;
    private Double amount;
    private PaymentMethod paymentMethod;
    private LocalDate paymentDate;
}

