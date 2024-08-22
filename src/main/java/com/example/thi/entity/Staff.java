package com.example.thi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;
import org.hibernate.validator.constraints.Length;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.UUID;

@Getter
@Setter
@Entity
@EnableJpaAuditing
@Configuration
@Table(name = "staff")
public class Staff {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @PrePersist
    public void generateId() {
        if (id == null) {
            id = UUID.randomUUID();
        }
    }

    @Column(name = "status", columnDefinition = "tinyint")
    private Short status;

    @CreatedDate
    @Column(name = "created_date")
    private Long createdDate;

    @LastModifiedDate
    @Column(name = "last_modified_date")
    private Long lastModifiedDate;

    @NotBlank(message = "Email FE không được bỏ trống")
    @Email(message = "Email FE không hợp lệ")
    @Pattern(regexp = "^[^\\s]+@fe\\.edu\\.vn$", message = "Email FE phải kết thúc với @fe.edu.vn và không chứa khoảng trắng")
    @Column(name = "account_fe")
    private String accountFe;

    @NotBlank(message = "Email FPT không được bỏ trống")
    @Email(message = "Email FPT không hợp lệ")
    @Pattern(regexp = "^[^\\s]+@fpt\\.edu\\.vn$", message = "Email FPT phải kết thúc với @fpt.edu.vn và không chứa khoảng trắng")
    @Column(name = "account_fpt")
    private String accountFpt;

    @NotBlank(message = "Tên nhân viên không được bỏ trống")
    @Length(max = 100, message = "Tên nhân viên không được vượt quá 100 ký tự")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Mã nhân viên không được bỏ trống")
    @Length(max = 15, message = "Mã nhân viên không được vượt quá 15 ký tự")
    @Column(name = "staff_code")
    private String staffCode;

}