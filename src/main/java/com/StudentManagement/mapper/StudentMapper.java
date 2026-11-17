package com.StudentManagement.mapper;

import com.StudentManagement.dto.StudentDTO;
import com.StudentManagement.entity.StudentEntity;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    public StudentDTO entityToDTO(StudentEntity  studentEntity){
        StudentDTO studentDTO=new StudentDTO();
        studentDTO.setFirstName(studentEntity.getFirstName());
        studentDTO.setLastName(studentEntity.getLastName());
        studentDTO.setEmail(studentEntity.getEmail());
        studentDTO.setPhone(studentEntity.getPhone());
        studentDTO.setAge(studentEntity.getAge());
        studentDTO.setCourse(studentEntity.getCourse());
        studentDTO.setCity(studentEntity.getCity());
        return studentDTO;
    }
    public StudentEntity DTOtoEntity(StudentDTO studentDTO){
        return StudentEntity.builder()
                .firstName(studentDTO.getFirstName())
                .lastName(studentDTO.getLastName())
                .email(studentDTO.getEmail())
                .phone(studentDTO.getPhone())
                .age(studentDTO.getAge())
                .course(studentDTO.getCourse())
                .city(studentDTO.getCity())
                .build();

    }
}
