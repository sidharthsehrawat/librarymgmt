package com.example.sociopool.service;

import com.example.sociopool.exception.TeacherNotRegisterException;
import com.example.sociopool.model.AttendenceEntity;
import com.example.sociopool.model.StudentEntity;
import com.example.sociopool.model.TeacherEntity;

import java.util.Date;
import java.util.List;

public interface AppService {


   // int searchDistanceCovered(String uid, Date startTime, Date endTime) throws UserNotRegisterException;

    StudentEntity registerStudent(StudentEntity dtoTOEntityConvertor) throws TeacherNotRegisterException;

    TeacherEntity registerTeacher(TeacherEntity dtoTOEntityTeacherConvertor);

    AttendenceEntity markAttendence(AttendenceEntity dtoTOEntityAttendenceConvertor) throws TeacherNotRegisterException;

    StudentEntity studentCheckTheirAttendence(String roll, Date markdate1) throws TeacherNotRegisterException;


    List<StudentEntity> teacherCheckStudentAttendenceByMarkDate(String roll, Date markdate1, String class1, Long teacherId);

    List<StudentEntity> teacherCheckStudentAttendenceByRollAndMarkDate(String roll, Date markdate1, String class1, Long teacherId);
}
