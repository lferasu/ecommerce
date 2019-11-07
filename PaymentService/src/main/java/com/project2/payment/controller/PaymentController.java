package com.project2.payment.controller;

import com.project2.payment.controller.model.Payment;
import com.project2.payment.controller.model.Reciept;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @PostMapping("/creditcard")
    ResponseEntity<Reciept> payWithCreditCard(@RequestBody Payment payment) {
        return  null;
    }

    @PostMapping("/bank")
    ResponseEntity<Reciept> payWithBankAccount(@RequestBody Payment payment) {
        return  null;
    }

    @PostMapping("/paypal")
    ResponseEntity<Reciept> payWithPaypal(@RequestBody Payment payment) {
        return  null;
    }

}
