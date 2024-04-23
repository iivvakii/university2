package com.example.university2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class EnrollToSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne
    private Subject subject;

    @OneToOne
    private Student student;

    private Date enrollDate;

    public void assignSubject(Subject subject){
        this.subject = subject;
    }

    public void assignStudent(Student student){
        this.student = student;
    }
}
