/*
 * Author : Anisha Palei
 * Date : 11-02-2023
 * Created with : IntelliJ IDEA Community Edition
 */

package com.niit.bej.service;

import com.niit.bej.domain.Customer;
import com.niit.bej.exception.CustomerNotFoundException;
import com.niit.bej.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    @Override
    public Customer registerUser(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public Customer login(String emailId, String password) throws CustomerNotFoundException {
        Customer loginUser = customerRepo.findByEmailIdAndPassword(emailId, password);
        if (loginUser == null) {
            throw new CustomerNotFoundException();
        }
        return loginUser;
    }
}