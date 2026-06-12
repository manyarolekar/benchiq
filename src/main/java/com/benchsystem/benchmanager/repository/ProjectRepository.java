package com.benchsystem.benchmanager.repository;

import com.benchsystem.benchmanager.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByStatus(String status);
}