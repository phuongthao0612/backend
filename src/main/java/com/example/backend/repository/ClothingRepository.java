package com.example.backend.repository;

import com.example.backend.model.Clothing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClothingRepository extends JpaRepository<Clothing, Integer> {
    @Query("SELECT c FROM Clothing c " +
            "WHERE (:name = '' OR LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%'))) " +
            "AND (:typeName = '' OR c.type.name = :typeName) " +
            "ORDER BY c.quantity ASC")
    List<Clothing> searchClothings(@Param("name") String name,
                                   @Param("typeName") String typeName);


}
