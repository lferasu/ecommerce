import { Component } from '@angular/core';
import { CartService } from './Services/cart.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  number = 0;
  constructor(cartService: CartService) {
    cartService.getNavChangeEmitter().subscribe(data => {
      this.number = data;
    })
  }
  title = 'client';
}
