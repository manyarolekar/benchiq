package com.benchsystem.benchmanager.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "allocations")
public class Allocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    private LocalDate allocationDate;
    private int matchScore;

    public Allocation() {}

    public Allocation(Employee employee, Project project, int matchScore) {
        this.employee = employee;
        this.project = project;
        this.matchScore = matchScore;
        this.allocationDate = LocalDate.now();
    }

    public Long getId() { return id; }
    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee e) { this.employee = e; }
    public Project getProject() { return project; }
    public void setProject(Project p) { this.project = p; }
    public LocalDate getAllocationDate() { return allocationDate; }
    public int getMatchScore() { return matchScore; }
    public void setMatchScore(int s) { this.matchScore = s; }
}