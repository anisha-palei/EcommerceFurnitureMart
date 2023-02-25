package com.niit.bej.repository;

import com.niit.bej.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,String> {
    Customer findByEmailIdAndPassword(String emailId, String password);
}
