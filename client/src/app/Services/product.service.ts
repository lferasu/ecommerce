import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from '../model/Product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  products_url = "34.69.71.153"   
  constructor(private httpClient: HttpClient) {

  }

  ngOnInit() {

  }

  getAllProducts() {
    return this.httpClient.get("http://"+this.products_url+"/products")
  }

  registerProduct(product: Product) {
    return this.httpClient.post("http://"+this.products_url+"/products", product)
  }
}
