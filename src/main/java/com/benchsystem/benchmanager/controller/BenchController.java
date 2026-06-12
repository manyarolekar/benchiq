package com.benchsystem.benchmanager.controller;

import com.benchsystem.benchmanager.model.*;
import com.benchsystem.benchmanager.repository.*;
import com.benchsystem.benchmanager.service.AIMatchingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class BenchController {

    @Autowired EmployeeRepository employeeRepo;
    @Autowired ProjectRepository projectRepo;
    @Autowired AIMatchingService aiService;

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee e) {
        return employeeRepo.save(e);
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    @GetMapping("/employees/benched")
    public List<Employee> getBenchedEmployees() {
        return employeeRepo.findByCurrentStatus("BENCHED");
    }

    @PostMapping("/projects")
    public Project addProject(@RequestBody Project p) {
        return projectRepo.save(p);
    }

    @GetMapping("/projects")
    public List<Project> getAllProjects() {
        return projectRepo.findAll();
    }

    @GetMapping("/projects/open")
    public List<Project> getOpenProjects() {
        return projectRepo.findByStatus("OPEN");
    }

    @GetMapping("/ai/match/{projectId}")
    public List<Map<String, Object>> findMatches(@PathVariable Long projectId) {
        return aiService.findBestMatches(projectId);
    }

    @PostMapping("/ai/allocate/{projectId}")
    public Map<String, Object> allocate(@PathVariable Long projectId) {
        return aiService.allocateBestFit(projectId);
    }

    @GetMapping("/ai/bench-alerts")
    public List<Map<String, Object>> benchAlerts() {
        return aiService.getBenchAlerts();
    }
}