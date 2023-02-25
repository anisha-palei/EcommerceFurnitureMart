package com.niit.bej.repository;

import com.niit.bej.domain.Furniture;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FurnitureRepo extends MongoRepository<Furniture,Integer> {
}
