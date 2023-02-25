package com.niit.bej.repository;

import com.niit.bej.domain.CustomerDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<CustomerDetails,String> {


}
