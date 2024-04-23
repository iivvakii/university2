package com.example.university2.service.impl;

import com.example.university2.model.Grade;
import com.example.university2.model.Student;
import com.example.university2.model.Subject;
import com.example.university2.repository.GradeRepository;
import com.example.university2.service.GradeService;
import com.example.university2.service.StudentService;
import com.example.university2.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {

    private final GradeRepository gradeRepository;
    private final SubjectService subjectService;
    private final StudentService studentService;

    @Autowired
    public GradeServiceImpl(GradeRepository gradeRepository, SubjectService subjectService, StudentService studentService) {
        this.gradeRepository = gradeRepository;
        this.subjectService = subjectService;
        this.studentService = studentService;
    }


    @Override
    public List<Grade> getAll() {
        return gradeRepository.findAll();
    }

    @Override
    public void add(Grade grade) {
        gradeRepository.save(grade);
    }

    @Override
    public void delete(Long id) {
        gradeRepository.deleteById(id);
    }

    @Override
    public Grade get(Long id) {
        return gradeRepository.findById(id).orElse(null);
    }


    @Override
    public Grade setGrade(double grade, Long student_id, Long subject_id) {
        Grade gradeModel = new Grade();
        Subject subject = subjectService.get(subject_id);
        Student student = studentService.get(student_id);
        gradeModel.assignGrade(subject.getTeacher(), grade);
        gradeModel.assignSubject(subject);
        gradeModel.assignStudent(student);
        return gradeRepository.save(gradeModel);
    }
}
