package com.example.university2.service;

import com.example.university2.model.Grade;

public interface GradeService extends Service<Grade>{
    Grade setGrade(double grade, Long student_id, Long subject_id);
}
