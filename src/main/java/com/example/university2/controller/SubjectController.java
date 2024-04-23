package com.example.university2.controller;

import com.example.university2.model.Student;
import com.example.university2.model.Subject;
import com.example.university2.model.Teacher;
import com.example.university2.repository.SubjectRepository;
import com.example.university2.service.impl.StudentServiceImpl;
import com.example.university2.service.impl.SubjectServiceImpl;
import com.example.university2.service.impl.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/subject")
public class SubjectController {

    private final SubjectServiceImpl subjectService;
    private final StudentServiceImpl studentService;
    private final SubjectRepository subjectRepository;
    private final TeacherServiceImpl teacherRepository;
    @Autowired
    public SubjectController(SubjectServiceImpl subjectService, StudentServiceImpl studentService, SubjectRepository subjectRepository, TeacherServiceImpl teacherRepository) {
        this.subjectService = subjectService;
        this.studentService = studentService;
        this.subjectRepository = subjectRepository;

        this.teacherRepository = teacherRepository;
    }

    @GetMapping("/all")
    public List<Subject> getAllSubjects(){
        return subjectService.getAll();
    }

    @PostMapping
    public void addNewSubject(@RequestBody Subject subject){
        subjectService.add(subject);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteSubject(@PathVariable("studentId") Long subjectId){
        subjectService.delete(subjectId);
    }

    @PutMapping("/{subject_id}/students/{student_id}")
    public Subject enrollToSubject(
            @PathVariable Long student_id,
            @PathVariable Long subject_id
    ){
        Subject subject = subjectService.get(subject_id);
        Student student = studentService.get(student_id);
        subject.enrollStudent(student);
        return subjectRepository.save(subject);
    }


    @PutMapping("/{subject_id}/teacher/{teacher_id}")
    public Subject enrollTeacherToSubject(
            @PathVariable Long teacher_id,
            @PathVariable Long subject_id
    ){
        Subject subject = subjectService.get(subject_id);
        Teacher teacher = teacherRepository.get(teacher_id);
        subject.assingTeacher(teacher);
        return subjectRepository.save(subject);
    }
}
