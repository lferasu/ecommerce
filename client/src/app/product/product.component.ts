import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
import { Product } from '../model/Product'
import { ProductService } from '../Services/product.service'

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  productForm: FormGroup;
  product: Product;

  constructor(private fb: FormBuilder, private productService: ProductService) {
    this.productForm = this.fb.group({
      'name': ['', Validators.required],
      'vendor': ['', Validators.required],
      'price': ['', Validators.required],
      'category': ['', Validators.required],
      'imageUrl': ['', Validators.required],
      'availableInventory': ['', Validators.required],
      'unit': ['', Validators.required]
    });
  }

  ngOnInit() {
  }

  submitForm() {
    this.product = this.productForm.value;
    this.productService.registerProduct(this.product).subscribe(data => console.log(data))
    this.productForm.reset();
  }


}
