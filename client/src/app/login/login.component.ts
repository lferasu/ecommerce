import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from '../model/User'
import { AuthService } from '../Services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  isSubmitted = false;
  userInfo: User
  constructor(private authService: AuthService, private router: Router, private formBuilder: FormBuilder) {

  }

  ngOnInit() {
    if (this.authService.isLoggedIn()) {
      console.log("is logged in.........")
      localStorage.removeItem('ACCESS_TOKEN');
      this.router.navigate(['/product'])
    } else {
      console.log("is Not logged in")

      this.loginForm = this.formBuilder.group({
        username: ['', Validators.required],
        password: ['', Validators.required]
      });
    }
  }

  login() {
    console.log(this.loginForm.value);
    this.isSubmitted = true;
    if (this.loginForm.invalid) {
      return;
    }

    this.authService.login(this.loginForm.value).subscribe(data => {
      localStorage.setItem('ACCESS_TOKEN', data.accessToken);
      this.router.navigate(['/catalog'])
    },
      err => {
        alert(err);
      });

  }


}
