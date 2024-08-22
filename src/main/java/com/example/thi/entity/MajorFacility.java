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
@Table(name = "major_facility")
public class MajorFacility {
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
    @JoinColumn(name = "id_department_facility")
    private DepartmentFacility idDepartmentFacility;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_major")
    private Major idMajor;

}