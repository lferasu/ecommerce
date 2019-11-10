import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ProductService } from '../Services/product.service';

@Component({
  selector: 'app-paypal',
  templateUrl: './paypal.component.html',
  styleUrls: ['./paypal.component.css']
})
export class PaypalComponent implements OnInit {

  creditCardForm: FormGroup;
  constructor(private fb: FormBuilder, private productService: ProductService) {
    this.creditCardForm = this.fb.group({
      'paypalAccount': ['', Validators.required]
    });
  }

  ngOnInit() {
  }

}
