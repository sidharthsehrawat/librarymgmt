package com.example.sociopool.controller;

import com.example.sociopool.dto.AttendenceDTO;
import com.example.sociopool.dto.StudentDTO;
import com.example.sociopool.dto.TeacherDTO;
import com.example.sociopool.exception.TeacherNotRegisterException;
import com.example.sociopool.model.AttendenceEntity;
import com.example.sociopool.model.StudentEntity;
import com.example.sociopool.model.TeacherEntity;
import com.example.sociopool.service.AppService;
import com.example.sociopool.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/api")
public class AttendenceController {

    @Autowired
    AppService appService;

    @PostMapping("/registerStudent")
    public ResponseEntity<StudentEntity> registerStudent(@RequestBody StudentDTO studentDTO) throws TeacherNotRegisterException, ParseException {
        if (studentDTO != null) {
            if (studentDTO.getName() != null && studentDTO.getRoll() != null) {
                StudentEntity studentEntity = appService.registerStudent(ServiceImpl.dtoTOEntityConvertor(studentDTO));
                if(studentEntity==null){
                   throw new TeacherNotRegisterException("Already Registered");
                }
                return new ResponseEntity<StudentEntity>(studentEntity, HttpStatus.OK);
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return null;
    }


    @PostMapping("/registerTeacher")
    public ResponseEntity<TeacherEntity> registerStudent(@RequestBody TeacherDTO teacherDTO) throws TeacherNotRegisterException, ParseException {
        if (teacherDTO != null) {
            if (teacherDTO.getName() != null && teacherDTO.getClass1() != null) {
                TeacherEntity teacherEntity = appService.registerTeacher(ServiceImpl.dtoTOEntityTeacherConvertor(teacherDTO));
                if(teacherEntity==null){
                    throw new TeacherNotRegisterException("Teacher Already Registered");
                }
                return new ResponseEntity<TeacherEntity>(teacherEntity, HttpStatus.OK);
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return null;
    }

    @PostMapping("/markAttendence")
    public ResponseEntity<AttendenceEntity> markAttendence(@RequestBody AttendenceDTO attendenceDTO) throws TeacherNotRegisterException, ParseException {
        if (attendenceDTO != null) {
            if (attendenceDTO.getRoll() != null && attendenceDTO.getMarkDate() != null && attendenceDTO.getAttendence()!=null) {
                AttendenceEntity attendenceEntity = appService.markAttendence(ServiceImpl.dtoTOEntityAttendenceConvertor(attendenceDTO));
                return new ResponseEntity<AttendenceEntity>(attendenceEntity, HttpStatus.OK);
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return null;
    }

    @GetMapping("/studentCheckThierAttendence/{roll}/{markdate}")
    public ResponseEntity<StudentEntity> checkAttendence(@PathVariable("roll") String roll, @PathVariable("markdate") String markdate) throws TeacherNotRegisterException, ParseException {
        if (roll != null && markdate!=null) {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date markdate1= format.parse(markdate);
            System.out.println(markdate1);

               StudentEntity studentEntity= appService.studentCheckTheirAttendence(roll,markdate1);
               if(studentEntity!=null){
                   return new ResponseEntity<StudentEntity>(studentEntity, HttpStatus.OK);
               }

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return null;
    }

    @GetMapping("/teacherCheckStudentAttendenceByMarkDate/{roll}/{class}/{markdate}/{teacherId}")
    public ResponseEntity<List<StudentEntity>> teacherCheckStudentAttendenceByMarkDate(@PathVariable("roll") String roll, @PathVariable("class") String class1,@PathVariable("markdate") String markdate,@PathVariable("teacherId") Long teacherId) throws TeacherNotRegisterException, ParseException {
        if (roll != null && markdate!=null && class1!=null && teacherId!=null) {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date markdate1= format.parse(markdate);
            System.out.println(markdate1);

            List<StudentEntity> studentEntity= appService.teacherCheckStudentAttendenceByMarkDate(roll,markdate1,class1,teacherId);
            if(studentEntity!=null){
                return new ResponseEntity<List<StudentEntity>>(studentEntity, HttpStatus.OK);
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return null;
    }

    @GetMapping("/teacherCheckStudentAttendenceByRollAndMarkDate/{roll}/{class}/{markdate}/{teacherId}")
    public ResponseEntity<List<StudentEntity>> teacherCheckStudentAttendenceByRollAndMarkDate(@PathVariable("roll") String roll, @PathVariable("class") String class1,@PathVariable("markdate") String markdate,@PathVariable("teacherId") Long teacherId) throws TeacherNotRegisterException, ParseException {
        if (roll != null && markdate!=null && class1!=null && teacherId!=null) {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date markdate1= format.parse(markdate);
            System.out.println(markdate1);

            List<StudentEntity> studentEntity= appService.teacherCheckStudentAttendenceByRollAndMarkDate(roll,markdate1,class1,teacherId);
            if(studentEntity!=null){
                return new ResponseEntity<List<StudentEntity>>(studentEntity, HttpStatus.OK);
            }

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return null;
    }




   /* @GetMapping("/getDistance/{uid}/{startTime}/{endTime}")
    public ResponseEntity<Integer> searchContact(@PathVariable("uid") String uid, @PathVariable("startTime") String startTime,
                                                 @PathVariable("endTime") String endTime) throws UserNotRegisterException, ParseException {
        if (uid != null && startTime != null && endTime != null) { // 2020-07-09 12:40:01
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date startTimed = format.parse(startTime);
            System.out.println(startTimed); //

            DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
            Date endTimed1 = format1.parse(endTime);
            System.out.println(endTimed1);

            int userProfileEntity = appService.searchDistanceCovered(uid, startTimed, endTimed1);
            return new ResponseEntity<Integer>(userProfileEntity, HttpStatus.OK);
        }
        return null;
    }*/
}
