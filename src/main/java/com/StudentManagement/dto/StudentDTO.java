package com.StudentManagement.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    @NotBlank(message ="First name is required")
    private String firstName;
    @NotBlank(message ="Last name is required")
    private String lastName;
    @NotBlank(message ="Email is required")
    @Email(message = "Enter valid email address")
    private String email;
    @NotBlank(message ="Phone number is required")
    private String phone;
    @NotNull(message ="Age is required")
    private Integer age;
    @NotNull(message ="course is required")
    private String course;
    @NotNull(message ="city is required")
    private String city;

}
