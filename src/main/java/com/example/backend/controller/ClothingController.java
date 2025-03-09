package com.example.backend.controller;

import com.example.backend.model.Clothing;
import com.example.backend.model.Type;
import com.example.backend.service.IClothingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clothings")
@CrossOrigin(origins = "http://localhost:3000")
public class ClothingController {

    @Autowired
    private IClothingService clothingService;

    @GetMapping
    public List<Clothing> getAllClothings(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "type", required = false) String type) {
        if ((name != null && !name.trim().isEmpty()) ||
                (type != null && !type.trim().isEmpty())) {
            return clothingService.searchClothings(name, type);
        } else {
            return clothingService.getAllClothings();
        }
    }


    @GetMapping("/types")
    public List<Type> getAllTypes() {
        return clothingService.getAllTypes();
    }

    @PostMapping
    public Clothing createClothing(@RequestBody Clothing clothing) {
        return clothingService.createClothing(clothing);
    }

    @GetMapping("/{id}")
    public Clothing getClothingById(@PathVariable Integer id) {
        return clothingService.getClothingById(id);
    }

    @PutMapping("/{id}")
    public Clothing updateClothing(@PathVariable Integer id, @RequestBody Clothing clothing) {
        return clothingService.updateClothing(id, clothing);
    }

    @DeleteMapping("/{id}")
    public void deleteClothing(@PathVariable Integer id) {
        clothingService.deleteClothing(id);
    }
}
