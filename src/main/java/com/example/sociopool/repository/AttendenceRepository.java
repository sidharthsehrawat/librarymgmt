package com.example.sociopool.repository;

import com.example.sociopool.model.AttendenceEntity;
import com.example.sociopool.model.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface AttendenceRepository  extends JpaRepository<AttendenceEntity,Long> {

    @Query(value="SELECT * FROM attendence_record a WHERE a.roll =:roll AND a.markdate =:markdate AND a.class =:class1",nativeQuery = true)
    AttendenceEntity findRecord(@Param("roll") String roll, @Param("markdate") Date markdate, @Param("class1") String class1);

    @Query(value="SELECT * FROM attendence_record a WHERE a.markdate =:markdate AND a.class =:class1",nativeQuery = true)
    List<StudentEntity> findByMarkDateAndClass(Date markdate, String class1);

    @Query(value="SELECT * FROM attendence_record a WHERE a.markdate =:markdate AND a.roll =:roll",nativeQuery = true)
    List<StudentEntity> findByMarkDateAndRoll(Date markdate, String roll);
}
