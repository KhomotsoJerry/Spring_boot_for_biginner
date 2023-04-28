package com.khomotso.Springdemo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/students")
public class StudentController {
    private final InMemory inMemory;
    @Autowired
    public StudentController(InMemory inMemory){
        this.inMemory=inMemory;
    }
    @GetMapping
    public List<Student> findAllStudent(){
        return inMemory.findAllStudent();
    }
    @PostMapping
    public Student save(@RequestBody Student student){
         return inMemory.save(student);
    }
    @GetMapping("{email}")
    public Student findByEmail(@PathVariable ("email") String email){
        return inMemory.findByEmail(email);
    }
    @PutMapping
    public Student updateStudent(@RequestBody Student student){
        return inMemory.updateStudent(student);
    }
    @DeleteMapping("{email}")
    public void delete(@PathVariable ("email") String email){
        inMemory.delete(email);
    }

}
