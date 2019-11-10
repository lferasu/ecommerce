import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { UserService } from '../user.service';
import { User } from '../model/User'

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  signUpForm: FormGroup;
  constructor(private formBuilder: FormBuilder, private userService: UserService) {

    this.signUpForm = formBuilder.group({
      username: new FormControl(''),
      password: new FormControl(''),
      confirmPassword: new FormControl(''),
      fullName: new FormControl(''),
      avatar: new FormControl(''),
      dob: new FormControl(''),
      email: new FormControl(''),
      paymentInfo: formBuilder.group({
        bankNumber: new FormControl(''),
        routingNumber: new FormControl(''),
        creditCardNumber: new FormControl(''),
        securityNumber: new FormControl(''),
        expirationDate: new FormControl(''),
        paymentMethod: new FormControl(''),
      }),
      address: formBuilder.group({
        country: new FormControl(''),
        state: new FormControl(''),
        city: new FormControl(''),
        zip: new FormControl(''),
        street: new FormControl('')
      })

    });
  }

  ngOnInit() {
  }

  submitForm() {
    let user: User;
    user = this.signUpForm.value;
    user.paymentInfo.paymentMethod = 1;
    this.userService.registerUser(user).subscribe(data => {
      console.log("hello");
      console.log(data);
    })
  }
}


