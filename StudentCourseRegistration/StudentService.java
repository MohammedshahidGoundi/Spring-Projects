package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.model.Student;

@Service
public class StudentService {

    private List<Student> students = new ArrayList<>();

    public StudentService() {
        students.add(new Student(101, "Abhishek", "Java","abhishek@gmail.com", 24));
        students.add(new Student(102, "Rahul", "Spring Boot","rahul@gmail.com", 22));
        students.add(new Student(103, "Akshay", "Python","akshay@gmail.com", 21));
        students.add(new Student(104, "Priya", "SQL","priya@gmail.com", 25));
        students.add(new Student(105, "Shahid", "Web Development","shahid@gmail.com", 23));
        students.add(new Student(106, "Raj", "React","raj@gmail.com", 26));
    }

    public Student registerStudent(Student student) {
        students.add(student);
        return student;
    } 
    
    public List<Student> getAllStudents() {
        return students;
    }
    
    public Student getStudentById(int studentId) {
        for (Student student : students) {

            if (student.getStudentId() == studentId) {
                return student;
            }
        }

        throw new StudentNotFoundException( "Student with ID " + studentId + " not found");
    } 
    
    public Student updateStudent(int studentId, Student updatedStudent) {
        Student student = getStudentById(studentId);

        student.setStudentName(updatedStudent.getStudentName());
        student.setCourseName(updatedStudent.getCourseName());
        student.setEmail(updatedStudent.getEmail());
        student.setAge(updatedStudent.getAge());

        return student;
    }

    public String deleteStudent(int studentId) {
        Student student = getStudentById(studentId);
        students.remove(student);
        return "Student registration deleted successfully";
    }

    public List<Student> getStudentsByCourse(String courseName) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {

            if (student.getCourseName().equalsIgnoreCase(courseName)) {
                result.add(student);
            }
        }

        return result;
    }

    public List<Student> getStudentsByName(String studentName) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {

            if (student.getStudentName().equalsIgnoreCase(studentName)) {
                result.add(student);
            }
        }

        return result;
    } 
    
    public List<Student> getStudentsAboveAge(int age) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {

            if (student.getAge() > age) {
                result.add(student);
            }
        }

        return result;
    } 
    
    public List<Student> getStudentsByEmail( String email) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {

            if (student.getEmail().equalsIgnoreCase(email)) {
                result.add(student);
            }
        }

        return result;
    }
}
