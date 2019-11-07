package com.project2.payment.controller;

import com.project2.payment.controller.model.*;
import com.project2.payment.repository.RecieptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.ValidationException;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    RecieptRepository recieptRepository;

    @PostMapping("/creditcard")
    ResponseEntity<Reciept> payWithCreditCard(@RequestBody PaymentInfo paymentInfo) throws Exception {

        if(paymentInfo.getCreditCardNumber() == null ||
        paymentInfo.getExpirationDate() == null ||
        paymentInfo.getPaymentMethod() != PaymentMethod.CREDITCARD) {
            throw new ValidationException("Validation exception, Make sure that you have correct infromation about payment");
        }

        try {
            Reciept reciept = restTemplate.postForObject("http://localhost:8095/creditcards",paymentInfo,Reciept.class);
            recieptRepository.save(reciept);
            return  new ResponseEntity<Reciept>(reciept, HttpStatus.OK);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }



    @PostMapping("/bank")
    ResponseEntity<Reciept> payWithBankAccount(@RequestBody PaymentInfo paymentInfo) throws Exception {
        if(paymentInfo.getBankNumber() == null ||
                paymentInfo.getRoutingNumber() == null ||
                paymentInfo.getPaymentMethod() != PaymentMethod.BANKACCOUNT) {
            throw new ValidationException("Validation exception, Make sure that you have correct infromation about payment");
        }

        try {
            Reciept reciept = restTemplate.postForObject("http://localhost:8096/banks",paymentInfo,Reciept.class);
            recieptRepository.save(reciept);
            return  new ResponseEntity<Reciept>(reciept, HttpStatus.OK);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @PostMapping("/paypal")
    ResponseEntity<Reciept> payWithPaypal(@RequestBody PaymentInfo paymentInfo) throws Exception {
        if(paymentInfo.getEmail() == null ||
                paymentInfo.getPaymentMethod() != PaymentMethod.PAYPAL) {
            throw new ValidationException("Validation exception, Make sure that you have correct infromation about payment");
        }

        try {
            Reciept reciept = restTemplate.postForObject("http://localhost:8097/paypals",paymentInfo,Reciept.class);
            recieptRepository.save(reciept);
            return  new ResponseEntity<Reciept>(reciept, HttpStatus.OK);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @ExceptionHandler
    ResponseEntity<ErrorMessage> validationException (ValidationException e) {
        return new ResponseEntity<ErrorMessage>(new ErrorMessage(e.getMessage()),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    ResponseEntity<ErrorMessage> exception(Exception e) {
        return new ResponseEntity<ErrorMessage>(new ErrorMessage(e.getMessage()),HttpStatus.EXPECTATION_FAILED);
    }

}
