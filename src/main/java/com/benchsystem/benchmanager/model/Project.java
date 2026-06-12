package com.benchsystem.benchmanager.model;

import jakarta.persistence.*;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String projectName;
    private String clientName;
    private String requiredSkills;
    private int requiredExperience;
    private String status;

    public Project() {}

    public Project(String projectName, String clientName,
                   String requiredSkills, int requiredExperience) {
        this.projectName = projectName;
        this.clientName = clientName;
        this.requiredSkills = requiredSkills;
        this.requiredExperience = requiredExperience;
        this.status = "OPEN";
    }

    public Long getId() { return id; }
    public String getProjectName() { return projectName; }
    public void setProjectName(String n) { this.projectName = n; }
    public String getClientName() { return clientName; }
    public void setClientName(String c) { this.clientName = c; }
    public String getRequiredSkills() { return requiredSkills; }
    public void setRequiredSkills(String s) { this.requiredSkills = s; }
    public int getRequiredExperience() { return requiredExperience; }
    public void setRequiredExperience(int e) { this.requiredExperience = e; }
    public String getStatus() { return status; }
    public void setStatus(String s) { this.status = s; }
}