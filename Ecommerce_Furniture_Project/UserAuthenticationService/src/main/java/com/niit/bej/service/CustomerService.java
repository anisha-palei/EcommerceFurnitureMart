package com.niit.bej.service;

import com.niit.bej.domain.Customer;
import com.niit.bej.exception.CustomerNotFoundException;

public interface CustomerService {

    public Customer registerUser(Customer customer);
    public Customer login(String emailId , String password) throws CustomerNotFoundException;
}
