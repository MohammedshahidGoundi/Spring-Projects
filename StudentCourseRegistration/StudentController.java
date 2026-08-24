package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public Student registerStudent( @Valid @RequestBody Student student) {
        return service.registerStudent(student);
    } 
    
    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    @GetMapping("/{studentId}")
    public Student getStudentById(@PathVariable int studentId) {
        return service.getStudentById(studentId);
    } 
    
    @PutMapping("/{studentId}")
    public Student updateStudent(@PathVariable int studentId,@Valid @RequestBody Student student) {
        return service.updateStudent(studentId, student);
    }

    @DeleteMapping("/{studentId}")
    public String deleteStudent(@PathVariable int studentId) {
        return service.deleteStudent(studentId);
    }
    
    @GetMapping("/course/{courseName}")
    public List<Student> getStudentsByCourse( @PathVariable String courseName) {
        return service.getStudentsByCourse(courseName);
    }

    @GetMapping("/name/{studentName}")
    public List<Student> getStudentsByName(@PathVariable String studentName) {
        return service.getStudentsByName(studentName);
    }

    @GetMapping("/age/{age}")
    public List<Student> getStudentsAboveAge(@PathVariable int age) {
        return service.getStudentsAboveAge(age);
    }
    
    @GetMapping("/email/{email}")
    public List<Student> getStudentsByEmail( @PathVariable String email) {
        return service.getStudentsByEmail(email);
    }
}
