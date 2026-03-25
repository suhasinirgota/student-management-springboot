package com.app.studentapp.controller;

import com.app.studentapp.model.Student;
import com.app.studentapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import jakarta.validation.Valid;

@RestController
public class StudentController {

    @Autowired
    private StudentService service;


    @PostMapping("/add")
    public Student addStudent(@Valid @RequestBody Student student) {
        return service.saveStudent(student);
    }

    @GetMapping("/getAll")
    public List<Student> getStudents() {
        return service.getAllStudents();
    }

    @GetMapping("/get/{id}")
    public Student getStudent(@PathVariable int id) {
        return service.getStudentById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        service.deleteStudent(id);
        return "Deleted";
    }

    @PutMapping("/update/{id}")
    public Student updateStudent(
            @PathVariable int id,
            @Valid @RequestBody Student student) {

        return service.updateStudent(id, student);
    }
}