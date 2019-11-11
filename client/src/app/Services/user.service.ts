import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AuthService } from './auth.service';
import { User } from '../model/User';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  loggedInUser: User
  constructor(private httpClient: HttpClient, private authService: AuthService) {

  }

  getLoggedInUserInfo() {
    console.log(this.authService.getDecodedAccessToken().sub);
    const userService = process.env.USER_SERVICE;

    // return this.httpClient.get("http://localhost:8091/users/" + this.authService.getDecodedAccessToken().sub);
    return this.httpClient.get("http://"+userService+"/users/" + this.authService.getDecodedAccessToken().sub);
  }
}
