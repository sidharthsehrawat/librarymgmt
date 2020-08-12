package com.example.sociopool.repository;

import com.example.sociopool.model.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeacherRepository  extends JpaRepository<TeacherEntity,Long> {
   // TeacherEntity findByTid(long tid);

    TeacherEntity findByTeacherId(Long teacherId);
}
