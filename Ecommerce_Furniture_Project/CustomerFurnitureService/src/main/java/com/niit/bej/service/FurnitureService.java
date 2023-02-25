package com.niit.bej.service;

import com.niit.bej.domain.Furniture;

import java.util.List;

public interface FurnitureService {

    public Furniture addFurniture(Furniture furniture);

    List<Furniture> getAllFurniture();

    Furniture getFurnitureById(int furnitureId);


}
