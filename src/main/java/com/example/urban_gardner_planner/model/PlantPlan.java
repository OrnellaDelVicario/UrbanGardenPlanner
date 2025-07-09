package com.example.urban_gardner_planner.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Represents a gardening plan for a single plant.
 * This class maps to a document in the "plantplans" collection in MongoDB.
 */
@Document(collection = "plantplans")
public class PlantPlan {

    @Id // This annotation marks the 'id' field as the primary key (_id) in MongoDB

    private String id;
    private String name;
    private String plantingSeason;
    private String sunlightNeeds;
    private String wateringFreq;
    private String notes;

    // --- Constructors ---
    // A default constructor is often good practice for POJOs
    public PlantPlan() {
    }

    // Constructor with all fields (useful for creation)
    public PlantPlan(String id, String name, String plantingSeason, String sunlightNeeds, String wateringFreq, String notes) {
        this.id = id;
        this.name = name;
        this.plantingSeason = plantingSeason;
        this.sunlightNeeds = sunlightNeeds;
        this.wateringFreq = wateringFreq;
        this.notes = notes;
    }

    // --- Getters and Setters ---
    // These methods allow Spring Data to access and modify the private fields

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlantingSeason() {
        return plantingSeason;
    }

    public void setPlantingSeason(String plantingSeason) {
        this.plantingSeason = plantingSeason;
    }

    public String getSunlightNeeds() {
        return sunlightNeeds;
    }

    public void setSunlightNeeds(String sunlightNeeds) {
        this.sunlightNeeds = sunlightNeeds;
    }

    public String getWateringFreq() {
        return wateringFreq;
    }

    public void setWateringFreq(String wateringFreq) {
        this.wateringFreq = wateringFreq;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    // Optional: Override toString() for easier debugging
    @Override
    public String toString() {
        return "PlantPlan{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", plantingSeason='" + plantingSeason + '\'' +
                ", sunlightNeeds='" + sunlightNeeds + '\'' +
                ", wateringFreq='" + wateringFreq + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}