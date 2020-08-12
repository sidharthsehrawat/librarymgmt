package com.example.sociopool.service;

import com.example.sociopool.dto.AttendenceDTO;
import com.example.sociopool.dto.StudentDTO;
import com.example.sociopool.dto.TeacherDTO;
import com.example.sociopool.exception.TeacherNotRegisterException;
import com.example.sociopool.model.AttendenceEntity;
import com.example.sociopool.model.StudentEntity;
import com.example.sociopool.model.TeacherEntity;
import com.example.sociopool.repository.AttendenceRepository;
import com.example.sociopool.repository.StudentRepository;
import com.example.sociopool.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class ServiceImpl implements AppService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    AttendenceRepository attendenceRepository;

    public static StudentEntity dtoTOEntityConvertor(StudentDTO studentDTO) throws ParseException {
        StudentEntity studentEntity = null;
        if (studentDTO != null) {

           /* DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
            Date startTimed = format.parse(userProfileDTO.getStart());
            System.out.println(startTimed); //
          */
            studentEntity = new StudentEntity();
            studentEntity.setName(studentDTO.getName());
            studentEntity.setRoll(studentDTO.getRoll());
            studentEntity.setClass1(studentDTO.getClass1());
        }
        return studentEntity;
    }

    public static AttendenceEntity dtoTOEntityAttendenceConvertor(AttendenceDTO attendenceDTO) throws ParseException {
        AttendenceEntity attendenceEntity = null;
        if (attendenceDTO != null) {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
            Date markDate = format.parse(attendenceDTO.getMarkDate());//2020-08-12 12:45:22
            System.out.println(markDate);
            attendenceEntity = new AttendenceEntity();
            attendenceEntity.setRoll(attendenceDTO.getRoll());
            attendenceEntity.setAttendence(attendenceDTO.getAttendence());
            attendenceEntity.setMarkDate(markDate);
            attendenceEntity.setTid(attendenceDTO.getByTeacher());
            attendenceEntity.setClass1(attendenceDTO.getClass1());
        }
        return attendenceEntity;
    }


    @Override
    public StudentEntity registerStudent(StudentEntity studentEntity) throws TeacherNotRegisterException {
        if (studentEntity != null) {
            StudentEntity studentEntityByRoll = studentRepository.findByRoll(studentEntity.getRoll());
            if (studentEntityByRoll == null) {
                // token = generateToken();
                //userProfileEntity.setToken(token);
                studentEntity = studentRepository.saveAndFlush(studentEntity);
                return studentEntity;
            }
        }
        return null;
    }

    public static TeacherEntity dtoTOEntityTeacherConvertor(TeacherDTO teacherDTO) throws ParseException {
        TeacherEntity teacherEntity = null;
        if (teacherDTO != null) {
            teacherEntity = new TeacherEntity();
            teacherEntity.setName(teacherDTO.getName());
            teacherEntity.setClass1(teacherDTO.getClass1());
            teacherEntity.setTeacherId(teacherDTO.getTeacherId());
        }
        return teacherEntity;
    }

    @Override
    public TeacherEntity registerTeacher(TeacherEntity teacherEntity) {
        if (teacherEntity != null) {
            TeacherEntity teacherEntity1 = teacherRepository.findByTeacherId(teacherEntity.getTeacherId());
            if (teacherEntity1 == null) {
                // token = generateToken();
                //userProfileEntity.setToken(token);
                teacherEntity1 = teacherRepository.saveAndFlush(teacherEntity);
                return teacherEntity;
            }
        }
        return null;
    }

    @Override
    public AttendenceEntity markAttendence(AttendenceEntity attendenceEntity) throws TeacherNotRegisterException{
        if (attendenceEntity != null && attendenceEntity.getAttendence() != null && attendenceEntity.getMarkDate() != null &&
                attendenceEntity.getRoll() != null && attendenceEntity.getTid() != null) {
            // both Student and Teacher are already Registered...
            TeacherEntity teacherEntity = teacherRepository.findByTeacherId(attendenceEntity.getTid());
            StudentEntity studentEntity = studentRepository.findByRoll(attendenceEntity.getRoll());
            if (attendenceRepository.findRecord(attendenceEntity.getRoll(), attendenceEntity.getMarkDate(), attendenceEntity.getClass1()) == null) {
                if (teacherEntity != null && studentEntity != null) {
                    return attendenceRepository.saveAndFlush(attendenceEntity);
                }else {
                    throw new TeacherNotRegisterException("Student Or Teacher Not Registered...");
                }
            }
        }
        return null;
    }

    @Override
    public StudentEntity studentCheckTheirAttendence(String roll, Date markdate1) throws TeacherNotRegisterException {
        // check if Sudent is registered...
        StudentEntity studentEntity = studentRepository.findByRoll(roll);
        if (studentEntity != null) {
            StudentEntity studentEntity1 = studentRepository.checkAttendence(roll, markdate1);
            if (studentEntity1 != null) {
                return studentEntity1;
            }else {
                throw new TeacherNotRegisterException("Student Attendence Not Marked by Any Teacher...");
            }
        }
        return null;
    }

    @Override
    public List<StudentEntity> teacherCheckStudentAttendenceByMarkDate(String roll, Date markdate, String class1, Long teacherId) {
        //check if teacher is registered or not
        TeacherEntity teacherEntity=teacherRepository.findByTeacherId(teacherId);
        if(teacherEntity!=null){
            //find student markdate wise with class in which they study
            List<StudentEntity> studentEntity=attendenceRepository.findByMarkDateAndClass(markdate,class1);
            if(studentEntity!=null){
                return studentEntity;
            }
        }
        return null;
    }

    @Override
    public List<StudentEntity> teacherCheckStudentAttendenceByRollAndMarkDate(String roll, Date markdate, String class1, Long teacherId) {
        //check if teacher is registered or not
        TeacherEntity teacherEntity=teacherRepository.findByTeacherId(teacherId);
        if(teacherEntity!=null){
            //find student markdate wise with class in which they study
            List<StudentEntity> studentEntity=attendenceRepository.findByMarkDateAndRoll(markdate,roll);
            if(studentEntity!=null){
                return studentEntity;
            }
        }
        return null;
    }


}





