package com.khomotso.Springdemo.student;

import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentService {
    Student save(Student student);
    List<Student> findAllStudent();
    void delete(String email);
    Student updateStudent(Student student);
    Student findByEmail(String email);
}
