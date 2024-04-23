package com.example.university2.service.impl;

import com.example.university2.model.Subject;
import com.example.university2.repository.SubjectRepository;
import com.example.university2.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public List<Subject> getAll() {
        return (List<Subject>) subjectRepository.findAll();
    }

    @Override
    public void add(Subject subject) {

        subjectRepository.save(subject);
    }

    @Override
    public void delete(Long id) {
        subjectRepository.deleteById(id);
    }

    @Override
    public Subject get(Long id) {
        return subjectRepository.findById(id).orElse(null);
    }


}
