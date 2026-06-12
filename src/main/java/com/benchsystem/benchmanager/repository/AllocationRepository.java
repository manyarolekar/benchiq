package com.benchsystem.benchmanager.repository;

import com.benchsystem.benchmanager.model.Allocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllocationRepository extends JpaRepository<Allocation, Long> {}