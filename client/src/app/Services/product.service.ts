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
    const productsURL = process.env.PRODUCTS_SERVICE;

    return this.httpClient.get("http://"+productsURL+"/products")
  }

  registerProduct(product: Product) {
    const productsURL = process.env.PRODUCTS_SERVICE;

    return this.httpClient.post("http://"+productsURL+"/products", product)
  }
}
