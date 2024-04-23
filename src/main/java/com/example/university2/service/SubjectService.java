package com.example.university2.service;

import com.example.university2.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectService extends Service<Subject> {

    List<Subject> getAll();

    void add(Subject subject);

    void delete(Long id);

    Subject get(Long id);
}
