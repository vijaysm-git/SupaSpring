package com.project.springboot.model;

import jakarta.persistence.*;

import java.util.Objects;
@Entity
public class SoftwareEngineer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String techStack;
    @Column(columnDefinition ="TEXT")
    private String learningPathRecommendation;


    public SoftwareEngineer() {
    }

    public SoftwareEngineer(Integer id, String firstName, String techStack, String learningPathRecommendation) {
        this.id = id;
        this.firstName = firstName;
        this.techStack = techStack;
        this.learningPathRecommendation = learningPathRecommendation;
    }

    public String getTechStack() {
        return techStack;
    }

    public String getLearningPathRecommendation() {
        return learningPathRecommendation;
    }

    public void setLearningPathRecommendation(String learningPathRecommendation) {
        this.learningPathRecommendation = learningPathRecommendation;
    }

    public void setTechStack(String techStack) {
        this.techStack = techStack;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SoftwareEngineer that = (SoftwareEngineer) o;
        return Objects.equals(id, that.id) && Objects.equals(firstName, that.firstName) && Objects.equals(techStack, that.techStack) && Objects.equals(learningPathRecommendation, that.learningPathRecommendation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, techStack, learningPathRecommendation);
    }
}
