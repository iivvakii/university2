package com.example.university2.controller;

import com.example.university2.model.Student;
import com.example.university2.model.Teacher;
import com.example.university2.service.impl.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v2/teacher")
public class TeacherController {

    private final TeacherServiceImpl teacherService;
    @Autowired
    public TeacherController(TeacherServiceImpl teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/all")
    public List<Teacher> getAllTeachers(){
        return teacherService.getAll();
    }

    @PostMapping
    public void addNewStudent(@RequestBody Teacher teacher){
        teacherService.add(teacher);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long teacherId){
        teacherService.delete(teacherId);
    }
}
