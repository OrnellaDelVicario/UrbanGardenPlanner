package com.example.urban_gardner_planner.repository;

import com.example.urban_gardner_planner.model.PlantPlan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for PlantPlan entities.
 * This interface extends MongoRepository to provide standard CRUD operations
 * for PlantPlan objects, with String as the type of the ID field.
 */
@Repository // Optional: Marks this interface as a Spring repository component
public interface PlantPlanRepository extends MongoRepository<PlantPlan, String> {
    // Spring Data MongoDB will automatically generate the implementation
    // for standard CRUD operations based on the methods inherited from MongoRepository.
    // You can also define custom query methods here if needed, following Spring Data's naming conventions.
}