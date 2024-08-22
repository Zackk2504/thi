package com.example.thi.repository;

import com.example.thi.entity.MajorFacility;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MajorFacilityRepository extends JpaRepository<MajorFacility, UUID> {
//    List<MajorFacility> findByDepartmentFacilityId(UUID departmentFacilityId);
}