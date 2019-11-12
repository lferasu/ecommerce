import { Injectable } from '@angular/core';
import { User } from './model/User';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  auth_url ="35.193.244.58";

  constructor(private httpClient: HttpClient) { }


  registerUser(user: User) {
    return this.httpClient.post("http://"+this.auth_url+"/api/auth/signup", user);
  }
}
