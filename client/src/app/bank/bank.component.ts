import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ProductService } from '../Services/product.service';
import { User } from '../model/User';
import { UserService } from '../Services/user.service';

@Component({
  selector: 'app-bank',
  templateUrl: './bank.component.html',
  styleUrls: ['./bank.component.css']
})
export class BankComponent implements OnInit {

  creditCardForm: FormGroup;
  loggedInUser: User
  constructor(private fb: FormBuilder, private productService: ProductService, userService: UserService) {
    userService.getLoggedInUserInfo().subscribe(data => {
      this.loggedInUser = <User>data;
      this.creditCardForm = this.fb.group({
        'bankNumber': ['', Validators.required],
        'routingNumber': ['', Validators.required]
      });
    });
  }


  ngOnInit() {
  }

}
