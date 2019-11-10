package edu.mum.cs.auth.controllers;

import edu.mum.cs.auth.model.JwtResponse;
import edu.mum.cs.auth.model.User1;
import edu.mum.cs.auth.repositories.UserRepository;
import edu.mum.cs.auth.config.JwtTokenUtil;
import edu.mum.cs.auth.model.JwtRequest;
import edu.mum.cs.auth.model.User;
import edu.mum.cs.auth.request.LoginForm;
import edu.mum.cs.auth.request.SignUpForm;
import edu.mum.cs.auth.services.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class JwtAuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private JwtUserDetailsService userDetailsService;
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@Valid @RequestBody LoginForm authenticationRequest) throws Exception {
        Authentication authentication = authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        SecurityContextHolder.getContext().setAuthentication(authentication);

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());
//        final String token = jwtTokenUtil.generateToken(use
        final String token = jwtTokenUtil.generateJwtToken(authentication);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    @PostMapping("/signup")
    public ResponseEntity<User1> registerUser(@Valid @RequestBody User1 signUpForm) {
        if(userRepository.existsByUsername(signUpForm.getUsername())) {
           throw new ValidationException("Fail -> Username is already taken!");
        }

        if(userRepository.existsByEmail(signUpForm.getEmail())) {
            throw new ValidationException("Fail -> email is already taken!");
        }

        // Creating user's account
        User user = new User(signUpForm.getFullName(), signUpForm.getUsername(),
                signUpForm.getEmail(), encoder.encode(signUpForm.getPassword()));


        // save user info to user microservice

        User1 savedUser = restTemplate.postForObject("http://localhost:8091/users",signUpForm,User1.class);

        userRepository.save(user);

        return new ResponseEntity<User1>(savedUser, HttpStatus.OK);
    }


    @ExceptionHandler
    ResponseEntity<String> handleException(ValidationException e) {
        return  new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    private Authentication authenticate(String username, String password) throws Exception {
        try {
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}