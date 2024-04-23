package com.example.university2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;

    public double assignGrade(Double grade){
        return grade;
    }
//
//    @OneToMany(mappedBy = "subject")
//    private Set<Subject> subjects = new HashSet<>();

}
