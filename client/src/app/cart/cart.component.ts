import { Component, OnInit } from '@angular/core';
import { CartService } from '../Services/cart.service';
import { Product } from '../model/Product';
import { AuthService } from '../Services/auth.service';
import { Router } from '@angular/router';
import { Cart } from '../model/cart';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  userInfo
  totalPrice: number = 0
  products: Product[] = [];
  constructor(private cartService: CartService,
    private authService: AuthService,
    private router: Router) {
    this.userInfo = this.authService.getDecodedAccessToken();
    this.products = this.cartService.cart.products;
    this.products.forEach(x => this.totalPrice = this.totalPrice + <number>x.price);
    // alert(this.products[0].category);
  }

  ngOnInit() {
  }

  checkout() {
    let cart: Cart = {
      products: this.products,
      username: this.userInfo.sub,
      totalPrice: this.totalPrice,
      valid: true
    };

    this.cartService.addToCart(cart);
    this.router.navigate(['checkout']);
  }

}
