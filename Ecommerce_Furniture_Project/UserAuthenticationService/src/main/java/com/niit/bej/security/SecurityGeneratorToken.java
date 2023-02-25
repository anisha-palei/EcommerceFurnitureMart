package com.niit.bej.security;

import com.niit.bej.domain.Customer;

import java.util.Map;

public interface SecurityGeneratorToken {
    public Map<String,String> generateToken(Customer customer);
}
