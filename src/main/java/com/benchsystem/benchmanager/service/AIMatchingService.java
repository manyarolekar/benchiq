package com.benchsystem.benchmanager.service;

import com.benchsystem.benchmanager.model.*;
import com.benchsystem.benchmanager.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
public class AIMatchingService {

    @Autowired EmployeeRepository employeeRepo;
    @Autowired ProjectRepository projectRepo;
    @Autowired AllocationRepository allocationRepo;

    public int calculateMatchScore(Employee emp, Project proj) {

        int score = 0;

        String[] required = proj.getRequiredSkills().toLowerCase().split(",");
        String empSkills = emp.getSkills().toLowerCase();

        for (String skill : required) {
            if (empSkills.contains(skill.trim())) {
                score += 20;
            }
        }

        if (emp.getExperienceYears() >= proj.getRequiredExperience()) {
            score += 20;
        }

        if (emp.getBenchStartDate() != null) {
            long days = ChronoUnit.DAYS.between(emp.getBenchStartDate(), LocalDate.now());
            if (days > 60) score += 10;
            else if (days > 30) score += 5;
        }

        return Math.min(score, 100);
    }

    public List<Map<String, Object>> findBestMatches(Long projectId) {

        Project project = projectRepo.findById(projectId)
            .orElseThrow(() -> new RuntimeException("Project not found"));

        List<Employee> benchedEmployees = employeeRepo.findByCurrentStatus("BENCHED");
        List<Map<String, Object>> results = new ArrayList<>();

        for (Employee emp : benchedEmployees) {
            int score = calculateMatchScore(emp, project);

            if (score > 0) {
                Map<String, Object> match = new LinkedHashMap<>();
                match.put("employeeId", emp.getId());
                match.put("employeeName", emp.getName());
                match.put("skills", emp.getSkills());
                match.put("experienceYears", emp.getExperienceYears());
                match.put("matchScore", score);
                match.put("recommendation", score >= 60 ? "STRONG FIT" :
                                            score >= 40 ? "MODERATE FIT" : "WEAK FIT");
                results.add(match);
            }
        }

        results.sort((a, b) ->
            Integer.compare((int) b.get("matchScore"), (int) a.get("matchScore")));

        return results;
    }

    public Map<String, Object> allocateBestFit(Long projectId) {

        List<Map<String, Object>> matches = findBestMatches(projectId);

        if (matches.isEmpty()) {
            Map<String, Object> response = new LinkedHashMap<>();
            response.put("status", "FAILED");
            response.put("message", "No suitable benched employee found");
            return response;
        }

        Map<String, Object> topMatch = matches.get(0);
        Long empId = (Long) topMatch.get("employeeId");

        Employee employee = employeeRepo.findById(empId).get();
        Project project = projectRepo.findById(projectId).get();
        int score = (int) topMatch.get("matchScore");

        Allocation allocation = new Allocation(employee, project, score);
        allocationRepo.save(allocation);

        employee.setCurrentStatus("ALLOCATED");
        employeeRepo.save(employee);

        project.setStatus("FILLED");
        projectRepo.save(project);

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("status", "SUCCESS");
        response.put("allocatedEmployee", employee.getName());
        response.put("project", project.getProjectName());
        response.put("client", project.getClientName());
        response.put("matchScore", score);
        response.put("allocationDate", LocalDate.now().toString());
        return response;
    }

    public List<Map<String, Object>> getBenchAlerts() {

        List<Employee> benched = employeeRepo.findByCurrentStatus("BENCHED");
        List<Map<String, Object>> alerts = new ArrayList<>();

        for (Employee emp : benched) {
            if (emp.getBenchStartDate() == null) continue;

            long daysOnBench = ChronoUnit.DAYS.between(
                emp.getBenchStartDate(), LocalDate.now());

            if (daysOnBench >= 30) {
                Map<String, Object> alert = new LinkedHashMap<>();
                alert.put("employeeId", emp.getId());
                alert.put("name", emp.getName());
                alert.put("skills", emp.getSkills());
                alert.put("daysOnBench", daysOnBench);
                alert.put("urgency", daysOnBench > 60 ? "CRITICAL" :
                                     daysOnBench > 45 ? "HIGH" : "MEDIUM");
                alert.put("message", emp.getName() + " benched for "
                          + daysOnBench + " days — immediate allocation needed");
                alerts.add(alert);
            }
        }

        alerts.sort((a, b) ->
            Long.compare((long) b.get("daysOnBench"), (long) a.get("daysOnBench")));

        return alerts;
    }
}