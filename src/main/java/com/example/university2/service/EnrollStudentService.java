package com.example.university2.service;

import com.example.university2.model.EnrollToSubject;

public interface EnrollStudentService {
    EnrollToSubject enrollStudent(Long subject_id, Long student_id);
}
