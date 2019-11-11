import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ProductService } from '../Services/product.service';
import { UserService } from '../Services/user.service';
import { User } from '../model/User';

@Component({
  selector: 'app-cc',
  templateUrl: './cc.component.html',
  styleUrls: ['./cc.component.css']
})
export class CcComponent implements OnInit {

  creditCardForm: FormGroup;
  loggedInUser: User;
  constructor(private fb: FormBuilder, private productService: ProductService, userService: UserService) {

    userService.getLoggedInUserInfo().subscribe(data => {
      this.loggedInUser = <User>data;
      this.creditCardForm = this.fb.group({
        'creditCardNumber': ['', Validators.required],
        'securityNumber': ['', Validators.required],
        'expirationDate': ['', Validators.required]
      });
    })
  }

  ngOnInit() {

  }

  submitForm() {

  }

}
