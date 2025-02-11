package com.yourname.onlineexamsystem.controller;

import com.yourname.onlineexamsystem.model.Exam;
import com.yourname.onlineexamsystem.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/exams")  // ДОЛЖНО БЫТЬ УКАЗАНО!
public class ExamController {

    @Autowired
    private ExamRepository examRepository;

    @PostMapping
    public Exam createExam(@RequestBody Exam exam) {
        return examRepository.save(exam);
    }

    @GetMapping
    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exam> getExamById(@PathVariable Long id) {
        Optional<Exam> exam = examRepository.findById(id);
        return exam.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExam(@PathVariable Long id) {
        if (examRepository.existsById(id)) {
            examRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
