package com.porject2.cart.controller;

import com.porject2.cart.models.Cart;
import com.porject2.cart.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartRepository cartRepository;

    @GetMapping("/{username}")
    ResponseEntity<Cart> getCart(@PathVariable String username) {

        Cart cart = cartRepository.findByUsernameAndValid(username,true);
        return new ResponseEntity<Cart>(cart, HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<Cart> saveCart(@RequestBody Cart cart) {
        cart.getProducts().forEach(x->x.setId(null));
        Cart savedCart = cartRepository.save(cart);
        return new ResponseEntity<Cart>(savedCart, HttpStatus.OK);
    }
}
