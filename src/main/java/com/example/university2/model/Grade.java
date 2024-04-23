package com.example.university2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Student student;

    @OneToOne
    private Subject subject;

    private Double grade;


    public void assignSubject(Subject subject){
        this.subject = subject;
    }

    public void assignStudent(Student student){
        this.student = student;
    }
    public void assignGrade(Teacher teacher, Double grade){
        this.grade = teacher.assignGrade(grade);
    }

}
