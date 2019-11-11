import { Injectable } from '@angular/core';
import { User } from './model/User';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient: HttpClient) { }


  registerUser(user: User) {
    const authURL = process.env.USER_SERVICE;

    // return this.httpClient.post("http://localhost:8099/api/auth/signup", user);
    return this.httpClient.post("http://"+authURL+"/api/auth/signup", user);

  }
}
