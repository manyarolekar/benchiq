package com.benchsystem.benchmanager.repository;

import com.benchsystem.benchmanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByCurrentStatus(String status);
}