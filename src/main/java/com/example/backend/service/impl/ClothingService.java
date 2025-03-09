package com.example.backend.service.impl;

import com.example.backend.model.Clothing;
import com.example.backend.model.Type;
import com.example.backend.repository.ClothingRepository;
import com.example.backend.repository.TypeRepository;
import com.example.backend.service.IClothingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClothingService implements IClothingService {

    @Autowired
    private ClothingRepository clothingRepository;

    @Autowired
    private TypeRepository typeRepository;

    @Override
    public Clothing createClothing(Clothing clothing) {
        return clothingRepository.save(clothing);
    }

    @Override
    public List<Clothing> getAllClothings() {
        return clothingRepository.findAll(Sort.by(Sort.Direction.ASC, "quantity"));
    }

    @Override
    public Clothing getClothingById(Integer id) {
        Optional<Clothing> clothing = clothingRepository.findById(id);
        return clothing.orElseThrow(() -> new RuntimeException("Clothing not found"));
    }

    @Override
    public Clothing updateClothing(Integer id, Clothing clothing) {
        Clothing existingClothing = clothingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Clothing not found"));
        existingClothing.setCode(clothing.getCode());
        existingClothing.setName(clothing.getName());
        existingClothing.setQuantity(clothing.getQuantity());
        existingClothing.setDate(clothing.getDate());
        existingClothing.setType(clothing.getType());
        return clothingRepository.save(existingClothing);
    }

    @Override
    public void deleteClothing(Integer id) {
        Clothing clothing = clothingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Clothing not found"));
        clothingRepository.delete(clothing);
    }

    @Override
    public List<Type> getAllTypes() {
        return typeRepository.findAll();
    }
    @Override
    public List<Clothing> searchClothings(String name, String typeName) {
        if (name == null) name = "";
        if (typeName == null) typeName = "";
        return clothingRepository.searchClothings(name, typeName);
    }
}
