#!/bin/bash
sh BankService/startbankservice.sh&&
sh UserService/startuserservice.sh&&
sh CreditCardService/startcreditcardervice.sh&&
sh PaymentService/startpaymentservice.sh&&
sh PaypalService/startpaypalservice.sh&&
sh OrderService/startorderservice.sh&&
sh ProductService/startproductservice.sh&&
sh CartService/startcartservice.sh

