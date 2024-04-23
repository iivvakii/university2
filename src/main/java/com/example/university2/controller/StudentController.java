package com.example.university2.controller;

import com.example.university2.model.Student;
import com.example.university2.model.Subject;
import com.example.university2.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v2/student")
public class StudentController {
    private final StudentServiceImpl studentService;

    @Autowired
    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAll();
    }

    @PostMapping
    public void addNewStudent(@RequestBody Student student){
        studentService.add(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.delete(studentId);
    }



}
