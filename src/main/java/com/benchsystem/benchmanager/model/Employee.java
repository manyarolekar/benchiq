package com.benchsystem.benchmanager.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String currentStatus;
    private LocalDate benchStartDate;
    private int experienceYears;
    private String skills;

    public Employee() {}

    public Employee(String name, String email, String skills,
                    int experienceYears, String currentStatus) {
        this.name = name;
        this.email = email;
        this.skills = skills;
        this.experienceYears = experienceYears;
        this.currentStatus = currentStatus;
        this.benchStartDate = LocalDate.now();
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getCurrentStatus() { return currentStatus; }
    public void setCurrentStatus(String s) { this.currentStatus = s; }
    public LocalDate getBenchStartDate() { return benchStartDate; }
    public void setBenchStartDate(LocalDate d) { this.benchStartDate = d; }
    public int getExperienceYears() { return experienceYears; }
    public void setExperienceYears(int e) { this.experienceYears = e; }
    public String getSkills() { return skills; }
    public void setSkills(String skills) { this.skills = skills; }
}