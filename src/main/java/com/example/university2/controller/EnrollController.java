package com.example.university2.controller;

import com.example.university2.model.EnrollToSubject;
import com.example.university2.model.Student;
import com.example.university2.model.Subject;
import com.example.university2.repository.EnrollToSubjectRepository;
import com.example.university2.service.EnrollStudentService;
import com.example.university2.service.StudentService;
import com.example.university2.service.SubjectService;
import com.example.university2.service.impl.StudentServiceImpl;
import com.example.university2.service.impl.SubjectServiceImpl;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/enroll")
public class EnrollController {
    private final EnrollStudentService enrollStudentService;


    public EnrollController(EnrollStudentService enrollStudentService) {
        this.enrollStudentService = enrollStudentService;

    }

    @PutMapping("/{subject_id}/enroll/{student_id}")
    public EnrollToSubject enrollToSubject(
            @PathVariable Long student_id,
            @PathVariable Long subject_id
    ){
        return enrollStudentService.enrollStudent(subject_id, student_id);
    }




}
