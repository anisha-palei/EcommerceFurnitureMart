/*
 * Author : Anisha Palei
 * Date : 11-02-2023
 * Created with : IntelliJ IDEA Community Edition
 */

package com.niit.bej.controller;

import com.niit.bej.domain.Customer;
import com.niit.bej.exception.CustomerNotFoundException;
import com.niit.bej.security.SecurityGeneratorTokenImpl;
import com.niit.bej.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("http://localhost:4200")
public class CustomerController {
    @Autowired
    CustomerServiceImpl customerService;

    @Autowired
    SecurityGeneratorTokenImpl securityGeneratorToken;

    @PostMapping("/customer")
    public ResponseEntity<?> registerUser(@RequestBody Customer user){
        Customer newUser=customerService.registerUser(user);
        if(newUser!=null){
            return new ResponseEntity<Customer>(newUser, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<String>("Error Occurred",HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/login")
    public ResponseEntity<?> checkAuthentication(@RequestBody Customer customerCheck) throws CustomerNotFoundException {
        Customer customer=customerService.login(customerCheck.getEmailId(),customerCheck.getPassword());

        if(customer!=null) {
            return new ResponseEntity<>(securityGeneratorToken.generateToken(customer), HttpStatus.OK);
        }else{
            return new ResponseEntity<String>("Error Occurred",HttpStatus.NOT_FOUND);
        }
    }
}
