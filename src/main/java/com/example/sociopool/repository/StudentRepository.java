package com.example.sociopool.repository;

import com.example.sociopool.model.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Long> {

    StudentEntity findByRoll(String roll);

    @Query(value = "SELECT * FROM attendence_Record a WHERE a.roll =:roll AND a.markdate =:markdate" ,nativeQuery = true)
    StudentEntity checkAttendence(String roll, Date markdate);

   /*

    @Query(value = "SELECT * FROM user_profile u WHERE u.uid =:uid AND u.start <= :userStart AND u.end >= :userStart OR u.start <= :userEnd And u.end >= :userEnd OR u.start >= :userStart AND u.end <= :userEnd" ,nativeQuery = true)
    public List<StudentEntity> findDistance(@Param("uid") String uid, @Param("userStart") Date userStart, @Param("userEnd") Date userEnd);

    public List<StudentEntity> findAllByUid(String uid);

    */



}
