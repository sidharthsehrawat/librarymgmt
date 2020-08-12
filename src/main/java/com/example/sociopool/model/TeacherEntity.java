package com.example.sociopool.model;

import javax.persistence.*;

@Entity(name = "register_teacher")
@Table(name = "register_teacher")
public class TeacherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tid", nullable = false)
    private long tid;

    @Column(name = "name", nullable = false, length = 200)
    private String name;

    @Column(name = "class", nullable = false, length = 200)
    private String class1;

    @Column(name = "teacherId", nullable = false, length = 200,unique = true)
    private Long teacherId;

    public long getTid() {
        return tid;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public void setTid(long tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClass1() {
        return class1;
    }

    public void setClass1(String class1) {
        this.class1 = class1;
    }

    @Override
    public String toString() {
        return "TeacherEntity{" +
                "tid=" + tid +
                ", name='" + name + '\'' +
                ", class1='" + class1 + '\'' +
                ", teacherId='" + teacherId + '\'' +
                '}';
    }
}
