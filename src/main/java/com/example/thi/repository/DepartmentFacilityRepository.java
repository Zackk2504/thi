package com.example.thi.repository;

import com.example.thi.entity.DepartmentFacility;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface DepartmentFacilityRepository extends JpaRepository<DepartmentFacility, UUID> {
//    List<DepartmentFacility> findByFacilityId(UUID facilityId);
}