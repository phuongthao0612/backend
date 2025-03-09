package com.example.backend.service;

import com.example.backend.model.Clothing;
import com.example.backend.model.Type;

import java.util.List;

public interface IClothingService {
    Clothing createClothing(Clothing clothing);

    List<Clothing> getAllClothings();

    Clothing getClothingById(Integer id);

    Clothing updateClothing(Integer id, Clothing clothing);

    void deleteClothing(Integer id);

    List<Type> getAllTypes();

    List<Clothing> searchClothings(String name, String typeName);
}
