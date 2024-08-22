package com.example.thi.repository;

import com.example.thi.entity.Major;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MajorRepository extends JpaRepository<Major, UUID> {
}