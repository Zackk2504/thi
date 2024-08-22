package com.example.thi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "department_facility")
public class DepartmentFacility {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "status", columnDefinition = "tinyint")
    private Short status;
    @CreatedDate
    @Column(name = "created_date")
    private Long createdDate;
    @LastModifiedDate
    @Column(name = "last_modified_date")
    private Long lastModifiedDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_department")
    private Department idDepartment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_facility")
    private Facility idFacility;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_staff")
    private Staff idStaff;

}