package com.example.urban_gardner_planner.service;

import com.example.urban_gardner_planner.model.PlantPlan;
import com.example.urban_gardner_planner.repository.PlantPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlantPlanService {

    private final PlantPlanRepository repository;

    @Autowired
    public PlantPlanService(PlantPlanRepository repository) {
        this.repository = repository;
    }

    public PlantPlan addPlan(PlantPlan plan) {
        return repository.save(plan);
    }

    public List<PlantPlan> getAllPlans() {
        return repository.findAll();
    }

    public Optional<PlantPlan> getPlanById(String id) {
        return repository.findById(id);
    }

    public PlantPlan updatePlan(String id, PlantPlan updatedPlan) {
        updatedPlan.setId(id); // Ensure the ID from the path is set on the object
        return repository.save(updatedPlan);
    }

    public void deletePlan(String id) {
        repository.deleteById(id);
    }

    // --- Custom Query Service Methods ---

    public List<PlantPlan> findByPlantingSeason(String season) {
        return repository.findByPlantingSeason(season);
    }

    public List<PlantPlan> findBySunlightNeeds(String sunlight) {
        return repository.findBySunlightNeeds(sunlight);
    }

    public List<PlantPlan> searchByWateringFreq(String keyword) {
        return repository.findByWateringFreqContainingIgnoreCase(keyword);
    }

    public long countByPlantingSeason(String season) {
        return repository.countByPlantingSeason(season);
    }

    public List<PlantPlan> searchByName(String keyword) {
        return repository.findByNameContainingIgnoreCase(keyword);
    }

    public List<PlantPlan> findByNotesContainingIgnoreCaseAndSunlightNeeds(String notesKeyword, String sunlightNeeds){
        return repository.findByNotesContainingIgnoreCaseAndSunlightNeeds(notesKeyword, sunlightNeeds);
    }


    public long getTotalPlansCount() {
        return repository.count();
    }
}