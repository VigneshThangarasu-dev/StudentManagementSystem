package com.StudentManagement.repository;


import com.StudentManagement.entity.StudentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<StudentEntity,String> {
    boolean existsByEmail(String email);
}
