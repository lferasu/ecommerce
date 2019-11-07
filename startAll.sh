#!/bin/bash
echo hello 
echo whats up &&
cd commands && 
sh ./startbankservice.sh&&
sh ./startuserservice.sh&&
sh ./startcreditcardervice.sh&&
sh ./startpaymentservice.sh&&
sh ./startpaypalservice.sh&&
sh ./startorderservice.sh&&
sh ./startproductservice.sh&&
sh ./startcartservice.sh&&

