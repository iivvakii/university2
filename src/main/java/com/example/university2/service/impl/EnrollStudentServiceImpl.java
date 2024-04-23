package com.example.university2.service.impl;

import com.example.university2.model.EnrollToSubject;
import com.example.university2.model.Student;
import com.example.university2.model.Subject;
import com.example.university2.repository.EnrollToSubjectRepository;
import com.example.university2.service.EnrollStudentService;
import com.example.university2.service.StudentService;
import com.example.university2.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnrollStudentServiceImpl implements EnrollStudentService {
    private final EnrollToSubjectRepository enrollToSubjectRepository;
    private final SubjectService subjectService;
    private final StudentService studentService;

    @Autowired
    public EnrollStudentServiceImpl(EnrollToSubjectRepository enrollToSubjectRepository, SubjectService subjectService, StudentService studentService) {
        this.enrollToSubjectRepository = enrollToSubjectRepository;
        this.subjectService = subjectService;
        this.studentService = studentService;
    }

    @Override
    public EnrollToSubject enrollStudent(Long subject_id, Long student_id) {
        EnrollToSubject enrollToSubject = new EnrollToSubject();
        Subject subject = subjectService.get(subject_id);
        Student student = studentService.get(student_id);
//        subject.enrollStudent(student);
        enrollToSubject.assignSubject(subject);
        enrollToSubject.assignStudent(student);
        return enrollToSubjectRepository.save(enrollToSubject);
    }
}
