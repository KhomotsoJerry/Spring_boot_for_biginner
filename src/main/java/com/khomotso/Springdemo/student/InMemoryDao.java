package com.khomotso.Springdemo.student;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
@Service
public class InMemoryDao {
    private final List<Student> students = new ArrayList<>();

    public Student save(Student student) {
        students.add(student);
      return student;
    }


    public List<Student> findAllStudent() {
        return students;
    }


    public void delete(String email) {
        var student = findByEmail(email);
        if (email!=null){
            students.remove(email);
        }

    }

    public  Student findByEmail(String email) {
       return students.stream().filter(s->email.equals(s.getEmail())).findFirst().orElse(null);
    }


    public Student updateStudent(Student student) {
        var studentIndex= IntStream.range(0,students.size()).filter(index->students.get(index).getEmail()
                .equals(student.getEmail())).findFirst().orElse(-1);
        if (studentIndex>-1){
            students.set(studentIndex,student);
            return student;
        }

        return null;
    }


}
