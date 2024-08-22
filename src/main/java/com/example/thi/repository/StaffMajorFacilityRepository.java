package com.example.thi.repository;

import com.example.thi.entity.StaffMajorFacility;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StaffMajorFacilityRepository extends JpaRepository<StaffMajorFacility, UUID> {
}