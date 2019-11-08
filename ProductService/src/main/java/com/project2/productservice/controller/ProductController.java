package com.project2.productservice.controller;

import com.project2.productservice.models.ErrorMessage;
import com.project2.productservice.models.Product;
import com.project2.productservice.models.ProductItem;
import com.project2.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping
    ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<List<Product>>(productRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<Product> registerProduct(@RequestBody Product product) throws ValidationException {
       if(!validate(product)){
           throw new ValidationException("invalid input");
       }

        return new ResponseEntity<Product>(productRepository.save(product), HttpStatus.OK);
    }

    private boolean validate(Product product) {
        product.setMinimumInventory(5);
        return (product!=null &&
                product.getCategory()!=null &&
                product.getImageUrl()!=null&&
                product.getName()!=null&&
                product.getPrice()!=null &&
                product.getVendor() !=null &&
                product.getAvailableInventory()!=null&&
                product.getUnit() !=null &&
                !product.getCategory().equals("")&&
                !product.getImageUrl().equals("")&&
                !product.getName().equals("")&&
                !product.getAvailableInventory().equals(0)&&
                !product.getUnit().equals(""));
    }

    @ExceptionHandler
    ResponseEntity<ErrorMessage> validationException (ValidationException e) {
        return new ResponseEntity<ErrorMessage>(new ErrorMessage(e.getMessage()),HttpStatus.BAD_REQUEST);
    }
}
