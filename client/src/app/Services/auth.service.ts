import { Injectable } from '@angular/core';
import { User } from '../model/User'
import { HttpClient } from '@angular/common/http';
import * as jwt_decode from "jwt-decode";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  loggedInUser: User
  url = "35.193.244.58"

  constructor(private httpClient: HttpClient) {

  }


  public login(userInfo: User) {

    // return this.httpClient.post("http://localhost:8099/api/auth/login", userInfo);
    return this.httpClient.post("http://"+this.url+"/api/auth/login", userInfo);

  }

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