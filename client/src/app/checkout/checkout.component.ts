import { Component, OnInit } from '@angular/core';
import { UserService } from '../Services/user.service';
import { User } from '../model/User';
import { ShipmentService } from '../Services/shipment.service';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {

  loggedInUser: User;
  addressString: String;
  paymentType: Number
  constructor(private userService: UserService, private shipmentService: ShipmentService) {
    this.userService.getLoggedInUserInfo().subscribe(data => {
      this.loggedInUser = <User>data;
      this.addressString = this.loggedInUser.address.zip + "," +
        this.loggedInUser.address.street + "," +
        this.loggedInUser.address.city + "," +
        this.loggedInUser.address.state + "," +
        this.loggedInUser.address.country;
    });


  }

  ngOnInit() {

  }
  creditCard(event) {
    this.paymentType = 0;
  }
  bank(event) {
    this.paymentType = 1;
  }

  paypal(event) {
    this.paymentType = 2;
  }

  checkout() {
    this.shipmentService.makeShipment(this.paymentType, this.loggedInUser);
  }

}
