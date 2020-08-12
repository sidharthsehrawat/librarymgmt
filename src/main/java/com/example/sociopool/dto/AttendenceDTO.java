package com.example.sociopool.dto;

public class AttendenceDTO {
    private String roll;
    private String attendence;
    private Long byTeacher;
    private String markDate;
    private String class1;

    public String getClass1() {
        return class1;
    }

    public void setClass1(String class1) {
        this.class1 = class1;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getAttendence() {
        return attendence;
    }

    public void setAttendence(String attendence) {
        this.attendence = attendence;
    }

    public Long getByTeacher() {
        return byTeacher;
    }

    public void setByTeacher(Long byTeacher) {
        this.byTeacher = byTeacher;
    }

    public String getMarkDate() {
        return markDate;
    }

    public void setMarkDate(String markDate) {
        this.markDate = markDate;
    }

    @Override
    public String toString() {
        return "AttendenceDTO{" +
                "roll='" + roll + '\'' +
                ", attendence='" + attendence + '\'' +
                ", byTeacher=" + byTeacher +
                ", markDate='" + markDate + '\'' +
                ", class1='" + class1 + '\'' +
                '}';
    }
}
