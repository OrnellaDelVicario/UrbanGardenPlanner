package com.example.urban_gardner_planner.repository;

import com.example.urban_gardner_planner.model.PlantPlan;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface PlantPlanRepository extends MongoRepository<PlantPlan, String> {

    // --- Custom Query Repository Methods ---

    List<PlantPlan> findByPlantingSeason(String plantingSeason);

    List<PlantPlan> findBySunlightNeeds(String sunlightNeeds);

    List<PlantPlan> findByWateringFreqContainingIgnoreCase(String keyword);

    long countByPlantingSeason(String plantingSeason);

    List<PlantPlan> findByNameContainingIgnoreCase(String keyword);

    //extra
    // --- NEW METHOD FOR NOTES AND SUNLIGHT ---
    /**
     * Finds PlantPlans where the notes contain a keyword (case-insensitive)
     * AND sunlight needs match exactly.
     *
     * @param notesKeyword  The keyword to search for in the notes.
     * @param sunlightNeeds
     * @return A list of matching PlantPlan objects.
     */
    List<PlantPlan> findByNotesContainingIgnoreCaseAndSunlightNeeds(String notesKeyword, String sunlightNeeds);

}