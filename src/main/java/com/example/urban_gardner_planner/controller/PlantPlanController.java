package com.example.urban_gardner_planner.controller;

import com.example.urban_gardner_planner.model.PlantPlan;
import com.example.urban_gardner_planner.service.PlantPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/plans")
public class PlantPlanController {

    private final PlantPlanService service;

    @Autowired
    public PlantPlanController(PlantPlanService service) {
        this.service = service;
    }

    // --- Basic CRUD Endpoints ---

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PlantPlan addPlan(@Valid @RequestBody PlantPlan plan) {
        return service.addPlan(plan);
    }

    @GetMapping
    public List<PlantPlan> getAllPlans() {
        return service.getAllPlans();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlantPlan> getPlanById(@PathVariable String id) {
        return service.getPlanById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public PlantPlan updatePlan(@PathVariable String id, @Valid @RequestBody PlantPlan updatedPlan) {
        return service.updatePlan(id, updatedPlan);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlan(@PathVariable String id) {
        service.deletePlan(id);
        return ResponseEntity.noContent().build();
    }

    // --- Custom Query Endpoints ---

    @GetMapping("/season/{season}")
    public List<PlantPlan> getByPlantingSeason(@PathVariable String season) {
        return service.findByPlantingSeason(season);
    }

    @GetMapping("/sunlight/{sunlight}")
    public List<PlantPlan> getBySunlightNeeds(@PathVariable String sunlight) {
        return service.findBySunlightNeeds(sunlight);
    }

    @GetMapping("/watering/search")
    public List<PlantPlan> searchByWateringFreq(@RequestParam String keyword) {
        return service.searchByWateringFreq(keyword);
    }

    @GetMapping("/count/season/{season}")
    public long countByPlantingSeason(@PathVariable String season) {
        return service.countByPlantingSeason(season);
    }

    @GetMapping("/search")
    public List<PlantPlan> searchByName(@RequestParam String keyword) {
        return service.searchByName(keyword);
    }

    @GetMapping("/notes-sunlight")
    public List<PlantPlan> getPlantsByNotesAndSunlight(
            @RequestParam("keyword") String notesKeyword,   // FIX: Explicitly map 'keyword' from URL
            @RequestParam("sunlight") String sunlightNeeds) { // FIX: Explicitly map 'sunlight' from URL
        return service.findByNotesContainingIgnoreCaseAndSunlightNeeds(notesKeyword, sunlightNeeds);
    }



    // --- Calculation Endpoint ---

    @GetMapping("/count/all")
    public long getTotalPlansCount() {
        return service.getTotalPlansCount();
    }
}