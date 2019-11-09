import { Component, OnInit } from '@angular/core';
import { Product } from '../model/Product'
import { ProductService } from '../Services/product.service'

@Component({
  selector: 'app-catalog',
  templateUrl: './catalog.component.html',
  styleUrls: ['./catalog.component.css']
})
export class CatalogComponent implements OnInit {

  products = {};
  constructor(private productService: ProductService) {
    productService.getAllProducts().subscribe((data) => this.products = data);
  }

  ngOnInit() {
  }

}
