package com.project.springboot.repository;

import com.project.springboot.model.SoftwareEngineer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoftwareEngineerRepository extends JpaRepository<SoftwareEngineer, Integer> {
}
