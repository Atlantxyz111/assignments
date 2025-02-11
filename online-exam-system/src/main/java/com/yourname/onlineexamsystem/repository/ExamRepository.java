package com.yourname.onlineexamsystem.repository;

import com.yourname.onlineexamsystem.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {
}
