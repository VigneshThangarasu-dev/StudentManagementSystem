package com.StudentManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "students")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StudentEntity {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Integer age;
    private String course;
    private String city;
}
