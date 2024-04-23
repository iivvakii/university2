package com.example.university2.controller;

import com.example.university2.model.Grade;
import com.example.university2.service.GradeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v2/grade")
public class GradeController {
    private final GradeService gradeService;

    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @PutMapping("{subject_id}/grade/{student_id}")
    public Grade setGrade(
            @RequestBody Double grade,
            @PathVariable Long student_id,
            @PathVariable Long subject_id){
        return gradeService.setGrade(grade, student_id, subject_id);
    }
}
