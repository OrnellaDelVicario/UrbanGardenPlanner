package com.example.urban_gardner_planner.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * Represents a gardening plan for a single plant.
 * This class maps to a document in the "plantplans" collection in MongoDB.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "plantplans")
public class PlantPlan {

    @Id // This annotation marks the 'id' field as the primary key (_id) in MongoDB
    private String id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Planting season is required")
    private String plantingSeason;

    @NotBlank(message = "Sunlight needs is required")
    private String sunlightNeeds;

    private String wateringFreq;
    private String notes;
}