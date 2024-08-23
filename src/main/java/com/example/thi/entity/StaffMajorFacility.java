package com.example.thi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.UUID;

@Getter
@Setter
@Entity

@Configuration
@Table(name = "staff_major_facility")
public class StaffMajorFacility {
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
    @JoinColumn(name = "id_major_facility")
    private MajorFacility idMajorFacility;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_staff")
    private Staff idStaff;

}