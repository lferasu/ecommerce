import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Shipment } from '../model/Shipment';
import { CartService } from './cart.service';
import { AuthService } from './auth.service';
import { UserService } from './user.service';
import { User } from '../model/User';
import { Observable, of } from 'rxjs'
import { Address } from '../model/Address';

@Injectable({
  providedIn: 'root'
})
export class ShipmentService {
  errorMessage: String;
  loggedInUser: User;
  constructor(private httpClient: HttpClient,
    private cartService: CartService,
    private authService: AuthService,
    private userService: UserService) { }


  async makeShipment(paymentType: Number, sh_user: User) {
    await this.userService.getLoggedInUserInfo().subscribe(data => {
      this.loggedInUser = <User>data;
    });
    let shipment: Shipment = {
      products: this.cartService.cart.products,
      address: sh_user.address,
      user: sh_user.username
    };
    console.log(this.cartService.cart.products)


    //makePayment

    try {
      if (paymentType == 0)
        this.httpClient.post('http://localhost:8094/payment/creditcard', {});
      if (paymentType == 1)
        this.httpClient.post('http://localhost:8094/payment/bank', this.loggedInUser.paymentInfo);
      if (paymentType == 2)
        this.httpClient.post('http://localhost:8094/payment/paypal', this.loggedInUser.paymentInfo);
    } catch {
      return of(this.errorMessage);
    }

    // save shipment
    this.httpClient.post('http://localhost:8098/products', shipment)

  }
}
