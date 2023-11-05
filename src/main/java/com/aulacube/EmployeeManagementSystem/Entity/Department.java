package com.aulacube.EmployeeManagementSystem.Entity;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.sql.Timestamp;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Department {
    @MongoId
    private String departmentId;
    private String departmentName;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
