package com.app.studentapp.service;
import com.app.studentapp.exception.StudentNotFoundException;
import com.app.studentapp.model.Student;
import com.app.studentapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student getStudentById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteStudent(int id) {
        repository.deleteById(id);
    }
    public Student updateStudent(int id, Student student) {

        Student old = repository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found with id " + id));

        old.setName(student.getName());
        old.setEmail(student.getEmail());
        old.setCourse(student.getCourse());

        return repository.save(old);
    }
}