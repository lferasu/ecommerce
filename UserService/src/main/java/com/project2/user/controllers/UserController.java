package com.project2.user.controllers;

import com.project2.user.models.User;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/users")
//public class UserController {
//
//    @PostMapping
//    ResponseEntity<User> addUser(@RequestBody User user) {
//
//        User myUser = user;
//        return null;
//    }
//
//}
