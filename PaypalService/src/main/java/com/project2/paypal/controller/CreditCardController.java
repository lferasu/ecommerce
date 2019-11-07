package com.project2.paypal.controller;

import com.project2.paypal.model.PaymentInfo;
import com.project2.paypal.model.Reciept;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/paypals")
public class CreditCardController {
    @PostMapping
    Reciept Reciept (@RequestBody PaymentInfo paymentinfo) {
        Reciept  reciept = new Reciept();
        reciept.setPayer(paymentinfo.getUserName());
        reciept.setAmount(paymentinfo.getAmount());
        reciept.setPaymentMethod(paymentinfo.getPaymentMethod());
        reciept.setPaymentDate(LocalDate.now());
        return reciept;
    }

}
