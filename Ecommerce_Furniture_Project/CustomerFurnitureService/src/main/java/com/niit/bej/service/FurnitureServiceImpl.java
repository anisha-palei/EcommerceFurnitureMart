/*
 * Author : Anisha Palei
 * Date : 11-02-2023
 * Created with : IntelliJ IDEA Community Edition
 */

package com.niit.bej.service;

import com.niit.bej.domain.Furniture;
import com.niit.bej.repository.FurnitureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FurnitureServiceImpl implements FurnitureService {
    @Autowired
    FurnitureRepo furnitureRepo;
    @Override
    public Furniture addFurniture(Furniture furniture) {
        return furnitureRepo.save(furniture);
    }

    @Override
    public List<Furniture> getAllFurniture() {
        return furnitureRepo.findAll();
    }

    @Override
    public Furniture getFurnitureById(int furnitureId) {
        return furnitureRepo.findById(furnitureId).get();
    }


}
