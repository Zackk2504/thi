package com.example.thi.repository;

import com.example.thi.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StaffRepository extends JpaRepository<Staff, UUID> {
    boolean existsByAccountFpt(String accountFpt);
    boolean existsByAccountFe(String accountFe);
    boolean existsByStaffCode(String staffCode);

}