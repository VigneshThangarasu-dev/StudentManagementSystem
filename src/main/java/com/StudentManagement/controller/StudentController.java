package com.StudentManagement.controller;

import com.StudentManagement.dto.StudentDTO;
import com.StudentManagement.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService service;
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public List<StudentDTO> getAllStudents(){
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentDTO getStudentById(@PathVariable String id){
        return service.getStudentById(id);
    }

    @PostMapping
    public StudentDTO createStudent(@Valid @RequestBody StudentDTO studentDTO){
        return service.createStudent(studentDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable String id){
        return service.deleteStudent(id);
    }

    @PutMapping("/{id}")
    public StudentDTO updateStudent(@PathVariable String id,@Valid @RequestBody StudentDTO studentDTO){
        return service.updateStudent(id,studentDTO);
    }

}
