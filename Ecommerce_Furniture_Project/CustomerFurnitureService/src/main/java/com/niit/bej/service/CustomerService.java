package com.niit.bej.service;

import com.niit.bej.domain.CustomerDetails;
import com.niit.bej.domain.Furniture;

import java.util.List;

public interface CustomerService {

    public CustomerDetails saveUser(CustomerDetails customerDetail);

    public CustomerDetails   detailsByEmailId(String emailId,Furniture furniture);

    CustomerDetails getCustomerByEmailId(String emailId);

    public List<Furniture> getAllFurnitureToCart(String emailId);









}
