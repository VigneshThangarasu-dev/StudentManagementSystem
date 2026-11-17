package com.StudentManagement.service;

import com.StudentManagement.dto.StudentDTO;
import com.StudentManagement.entity.StudentEntity;
import com.StudentManagement.exception.DuplicateEmailException;
import com.StudentManagement.exception.StudentNotFoundException;
import com.StudentManagement.mapper.StudentMapper;
import com.StudentManagement.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository repository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository repository, StudentMapper studentMapper) {
        this.repository = repository;
        this.studentMapper = studentMapper;
    }

    //crud
    public StudentDTO createStudent(StudentDTO studentDTO){
        if(repository.existsByEmail(studentDTO.getEmail())){
            throw new DuplicateEmailException("Email is already exists");
        }
        StudentEntity student= studentMapper.DTOtoEntity(studentDTO);
        StudentEntity savedStudent=repository.save(student);
        return studentMapper.entityToDTO(savedStudent);
    }
    //read by id
    public StudentDTO getStudentById(String id){
        StudentEntity student=repository.findById(id).orElseThrow(
                ()->new StudentNotFoundException("Student not found with id :"+id)
        );
        return studentMapper.entityToDTO(student);
    }
    //read all student
    public List<StudentDTO> getAllStudents(){
        return repository.findAll().stream().map(entity->studentMapper.entityToDTO(entity)).toList();
    }
    //delete
    public String deleteStudent(String id){
        StudentEntity student=repository.findById(id).orElseThrow(
                ()->new StudentNotFoundException("Student not found with id :"+id)
        );
        repository.deleteById(student.getId());
        return "Student deleted successfully!";
    }

    //update
    public StudentDTO updateStudent(String id,StudentDTO studentDTO){
        StudentEntity student=repository.findById(id).orElseThrow(
                ()->new StudentNotFoundException("Student not found with id :"+id)
        );
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(student.getLastName());
        student.setEmail(student.getEmail());
        student.setPhone(student.getPhone());
        student.setAge(student.getAge());
        student.setCourse(student.getCourse());
        student.setCity(student.getCity());
        StudentEntity savedStudent=repository.save(student);
        return studentMapper.entityToDTO(savedStudent);
    }
}
