package com.khomotso.Springdemo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InMemory implements StudentService{
    private final InMemoryDao dao;
    @Autowired
    public InMemory(InMemoryDao dao){
        this.dao=dao;
    }
    @Override
    public Student save(Student student) {
        return dao.save(student);
    }

    @Override
    public List<Student> findAllStudent() {
        return dao.findAllStudent();
    }

    @Override
    public void delete(String email) {
       dao.delete(email);
    }

    @Override
    public Student updateStudent(Student student) {
        return dao.updateStudent(student);
    }

    @Override
    public Student findByEmail(String email) {
        return dao.findByEmail(email);
    }
}
