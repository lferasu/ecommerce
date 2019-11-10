import { Injectable } from '@angular/core';
import { User } from '../model/User'
import { HttpClient } from '@angular/common/http';
import * as jwt_decode from "jwt-decode";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  loggedInUser: User
  constructor(private httpClient: HttpClient) {

  }

  public login(userInfo: User) {
    // console.log(userInfo)
    //console.log("hallo");
    return this.httpClient.post("http://localhost:8099/api/auth/login", userInfo);


  }
  // localStorage.setItem('ACCESS_TOKEN', "access_token");


  public isLoggedIn() {
    //console.log(localStorage.getItem('ACCESS_TOKEN'));
    return localStorage.getItem('ACCESS_TOKEN') != null;

  }

  public logout() {
    localStorage.removeItem('ACCESS_TOKEN');
  }

  getDecodedAccessToken(): any {
    let value = localStorage.getItem('ACCESS_TOKEN');
    try {
      return jwt_decode(localStorage.getItem('ACCESS_TOKEN'));
    }
    catch (Error) {
      return null;
    }
  }

}