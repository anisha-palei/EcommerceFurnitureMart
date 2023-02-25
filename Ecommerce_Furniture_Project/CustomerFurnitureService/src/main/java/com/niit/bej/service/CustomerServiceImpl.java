/*
 * Author : Anisha Palei
 * Date : 11-02-2023
 * Created with : IntelliJ IDEA Community Edition
 */

package com.niit.bej.service;

import com.niit.bej.domain.CustomerDetails;
import com.niit.bej.domain.Furniture;
import com.niit.bej.proxy.CustomerProxy;
import com.niit.bej.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class  CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;


@Autowired
    CustomerProxy customerProxy;

    @Override
    public CustomerDetails saveUser(CustomerDetails customerDetailsDetail) {
      CustomerDetails newUser= customerRepository.save(customerDetailsDetail);
      if(!newUser.getEmailId().isEmpty())
      {
          ResponseEntity responseEntity=customerProxy.saveUserInAuth(newUser);

      }
      return newUser;
    }

    @Override
    public CustomerDetails detailsByEmailId(String emailId, Furniture furniture) {
       CustomerDetails customerDetails=customerRepository.findById(emailId).get();
       if(customerDetails.getFurnitureList()==null)
       {
           customerDetails.setFurnitureList(Arrays.asList(furniture));
       }
       else
       {
           customerDetails.getFurnitureList().add(furniture);
       }
       return  customerRepository.save(customerDetails);
    }

    @Override
    public CustomerDetails getCustomerByEmailId(String emailId) {
        return customerRepository.findById(emailId).get();
    }

    @Override
    public List<Furniture> getAllFurnitureToCart(String emailId) {

        List<Furniture> furnitureList = customerRepository.findById(emailId).get().getFurnitureList();
        return furnitureList;

    }


}
