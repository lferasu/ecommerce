import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from '../model/Product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private httpClient: HttpClient) {

  }

  ngOnInit() {

  }

  getAllProducts() {
    return this.httpClient.get('http://localhost:8092/products')
  }

  registerProduct(product: Product) {
    console.log(product)
    return this.httpClient.post('http://localhost:8092/products', product)
  }
}
