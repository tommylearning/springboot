package com.learning.studentRecruitment.controller;

import com.learning.studentRecruitment.entities.Student;
import com.learning.studentRecruitment.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentRepository repository;

    @PostMapping("/student/create")
    public Student createStudent(@RequestBody Student student) {
        return repository.save(student);
    }

    @GetMapping("/student/all")
    public List<Student> getAllStudent(){
        return repository.findAll();
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable("id") int id){
        return repository.getById(id);
    }

    @PostMapping("/student/{id}")
    public Student updateStudent(@PathVariable("id") int id, @RequestBody Student student){
        Student data = repository.getById(id);
        data.setName(student.getName());
        data.setTestScore(student.getTestScore());
        return repository.save(data);
    }

    @DeleteMapping("/student/{id}")
    public void deleteStudent(@PathVariable("id") int id){
        Student data = repository.getById(id);
        repository.delete(data);
    }
}
