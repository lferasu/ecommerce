package com.porject2.cart.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ProductList {
   private List<Product> products;
}
