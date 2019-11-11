package com.porject2.cart.controller;

import com.porject2.cart.models.Product;
import com.porject2.cart.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.ValidationException;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductRepository productRepository;
    @PostMapping
    ResponseEntity<List<Product>> registerProduct(@RequestBody List<Product> products) throws ValidationException {
        List<Product> list = productRepository.saveAll(products);
        return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
    }
}
