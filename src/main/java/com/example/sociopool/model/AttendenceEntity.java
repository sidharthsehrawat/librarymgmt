package com.example.sociopool.model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "attendence_Record")
@Table(name = "attendence_Record")
public class AttendenceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attnid", nullable = false)
    private long attnid;

    @Column(name = "roll", nullable = false, length = 200)
    private String roll;

    @Column(name = "class", nullable = false, length = 200)
    private String class1;

    @Column(name = "attendence", nullable = false, length = 200)
    private String attendence;

    @Column(name = "tid", nullable = false, length = 200)
    private Long tid;

    @Column(name = "markdate", nullable = false, length = 200)
    @Temporal(value = TemporalType.TIMESTAMP)
    private java.util.Date markDate;

    public String getClass1() {
        return class1;
    }

    public void setClass1(String class1) {
        this.class1 = class1;
    }

    public long getAttnid() {
        return attnid;
    }

    public void setAttnid(long attnid) {
        this.attnid = attnid;
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

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public Date getMarkDate() {
        return markDate;
    }

    public void setMarkDate(Date markDate) {
        this.markDate = markDate;
    }

    @Override
    public String toString() {
        return "AttendenceEntity{" +
                "attnid=" + attnid +
                ", roll='" + roll + '\'' +
                ", class1='" + class1 + '\'' +
                ", attendence='" + attendence + '\'' +
                ", tid='" + tid + '\'' +
                ", markdate=" + markDate +
                '}';
    }
}
