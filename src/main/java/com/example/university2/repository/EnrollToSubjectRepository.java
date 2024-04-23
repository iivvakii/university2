package com.example.university2.repository;

import com.example.university2.model.EnrollToSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollToSubjectRepository extends JpaRepository<EnrollToSubject, Long> {
}
