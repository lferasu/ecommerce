import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { Product } from '../model/Product'
import { ProductService } from '../Services/product.service'
import { AuthService } from '../Services/auth.service';
import { Router } from '@angular/router';
import { Cart } from '../model/cart';
import { CartService } from '../Services/cart.service';

@Component({
  selector: 'app-catalog',
  templateUrl: './catalog.component.html',
  styleUrls: ['./catalog.component.css']
})
export class CatalogComponent implements OnInit {
  @Output() myevent: EventEmitter<Number> = new EventEmitter();
  public cartNumber: any = 0;
  products = {};
  userInfo;
  constructor(private productService: ProductService,
    private authService: AuthService,
    private router: Router,
    private cartService: CartService,
  ) {
    productService.getAllProducts().subscribe((data) => this.products = data);
  }

  ngOnInit() {


    this.userInfo = this.authService.getDecodedAccessToken();
    console.log(this.userInfo);
    // this.cartService.getCart(this.userInfo.sub).subscribe(data => {
    //   if (data != null) {
    //     this.cartService.cart = data
    //   }
    // });
  }

  addToCart(product) {
    if (!this.authService.isLoggedIn()) {
      this.router.navigate(['login']);
    }
    this.cartService.cart.username = this.userInfo.sub;
    this.cartService.cart.valid = true;
    this.cartService.cart.products.push(product);
    this.cartNumber = this.cartNumber + 1;
    this.cartService.emitNavChangeEvent(this.cartNumber);
    //this.cartService.savecart(this.cart);

  }
}
