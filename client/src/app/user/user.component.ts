import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
import { Product } from '../model/Product'
import { ProductService } from '../Services/product.service'

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  constructor(private fb: FormBuilder, private productService: ProductService) {

  }

  ngOnInit() {
  }

}
