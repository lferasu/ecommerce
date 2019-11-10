package com.project2.user.controllers;

import com.project2.user.models.User;
import com.project2.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping
    ResponseEntity<User> addUser(@RequestBody User user) throws Exception {

        try{
            User saveduser =  userRepository.save(user);
            return new ResponseEntity<User>(saveduser, HttpStatus.OK);
        } catch (Exception e) {
           throw new Exception(e);
        }

    }

    @GetMapping("/{username}")
    ResponseEntity<User> getUser(@PathVariable String username) {
        String s = username;
        System.out.println(s);
        try {
            User user =  userRepository.findByUsername(username);
            return  new ResponseEntity<User>(user, HttpStatus.OK);
        } catch (Exception e) {
            throw e;
        }

    }

    @ExceptionHandler
    ResponseEntity<String> handleException (Exception e) {
        return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
