import { Injectable, EventEmitter } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from '../model/Product';
import { Cart } from '../model/cart';
import { Observable } from 'rxjs'

@Injectable({
  providedIn: 'root'
})
export class CartService {

  cart: Cart = {
    username: "",
    products: [],
    totalPrice: 0,
    valid: false
  }

  cart_url = "130.211.202.40";

  // userInfo;
  navchange: EventEmitter<number> = new EventEmitter();
  constructor(private httpClient: HttpClient) {
    // this.userInfo = this.authService.getDecodedAccessToken();
  }
  savecart(cart: Cart) {
    console.log(cart);
    return this.httpClient.post("http://"+this.cart_url+"/cart/", cart);
  }

  getCart(userName: String) {
    return this.httpClient.get("http://"+this.cart_url+"/cart/" + userName);
  }

  async addToCart(cart: Cart) {
    console.log(cart);
    this.httpClient.post("http://"+this.cart_url+"/cart/", cart).subscribe(data => this.cart = <Cart>data);

  }

  getActiveCart() {
    return this.cart;
  }



  emitNavChangeEvent(number) {
    this.navchange.emit(this.cart.products.length);
  }

  getNavChangeEmitter() {
    return this.navchange;
  }

}
