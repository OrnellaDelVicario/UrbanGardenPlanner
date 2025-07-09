package com.example.urban_gardner_planner.controller;

import com.example.urban_gardner_planner.model.PlantPlan; // Adjust import as needed
import com.example.urban_gardner_planner.service.PlantPlanService; // Adjust import as needed
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus; // For HTTP status codes
import org.springframework.http.ResponseEntity; // For custom HTTP responses
import org.springframework.web.bind.annotation.*; // Contains common annotations like @RestController, @RequestMapping, etc.

import java.util.List;
import java.util.Optional;

    /**
     * REST Controller for Plant Plans.
     * Handles incoming HTTP requests related to PlantPlan resources.
     */
    @RestController // Combines @Controller and @ResponseBody
    @RequestMapping("/api/plans") // Base path for all endpoints in this controller
    public class PlantPlanController {

        private final PlantPlanService service; // Declare the service dependency

        // Constructor-based dependency injection
        @Autowired
        public PlantPlanController(PlantPlanService service) {
            this.service = service;
        }

        /**
         * Handles POST requests to add a new plant plan.
         * Maps to: POST /api/plans
         * @param plan The PlantPlan object received from the request body (JSON).
         * @return The PlantPlan object saved to the database with its ID.
         */
        @PostMapping
        @ResponseStatus(HttpStatus.CREATED) // Explicitly set 201 Created for successful resource creation
        public PlantPlan addPlan(@RequestBody PlantPlan plan) {
            return service.addPlan(plan);
        }

        /**
         * Handles GET requests to retrieve all plant plans.
         * Maps to: GET /api/plans
         * @return A list of all PlantPlan objects.
         */
        @GetMapping
        public List<PlantPlan> getAllPlans() {
            return service.getAllPlans();
        }

        /**
         * Handles GET requests to retrieve a single plant plan by ID.
         * Maps to: GET /api/plans/{id}
         * @param id The ID of the plant plan to retrieve, extracted from the URL path.
         * @return ResponseEntity containing the PlantPlan if found (200 OK), or 404 Not Found.
         */
        @GetMapping("/{id}")
        public ResponseEntity<PlantPlan> getPlanById(@PathVariable String id) {
            Optional<PlantPlan> plan = service.getPlanById(id);
            return plan.map(ResponseEntity::ok) // If plan is present, return 200 OK with the plan
                    .orElse(ResponseEntity.notFound().build()); // If not found, return 404 Not Found
        }

        /**
         * Handles PUT requests to update an existing plant plan.
         * Maps to: PUT /api/plans/{id}
         * @param id The ID of the plant plan to update, extracted from the URL path.
         * @param plan The PlantPlan object with updated information from the request body.
         * @return The updated PlantPlan object.
         */
        @PutMapping("/{id}")
        public PlantPlan updatePlan(@PathVariable String id, @RequestBody PlantPlan plan) {
            // The service layer handles the logic of finding and updating.
            // It might throw an exception if the ID is not found, which Spring will typically
            // convert to a 500 Internal Server Error unless specific exception handling is implemented.
            return service.updatePlan(id, plan);
        }

        /**
         * Handles DELETE requests to remove a plant plan.
         * Maps to: DELETE /api/plans/{id}
         * @param id The ID of the plant plan to delete, extracted from the URL path.
         * @return ResponseEntity with 204 No Content status if deletion is successful.
         */
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletePlan(@PathVariable String id) {
            service.deletePlan(id);
            return ResponseEntity.noContent().build(); // Returns 204 No Content on successful deletion
        }
    }
