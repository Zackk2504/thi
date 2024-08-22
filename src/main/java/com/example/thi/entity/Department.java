package com.example.thi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "department")
public class Department {
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

    @Nationalized
    @Column(name = "code")
    private String code;

    @Nationalized
    @Column(name = "name")
    private String name;

}