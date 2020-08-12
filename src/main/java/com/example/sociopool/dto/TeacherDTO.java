package com.example.sociopool.dto;

public class TeacherDTO {
    //private String tid;
    private String name;
    private String class1;
    private Long teacherId;

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

   /* public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }*/

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
        return "TeacherDTO{" +
               // "tid='" + tid + '\'' +
                ", name='" + name + '\'' +
                ", class1='" + class1 + '\'' +
                ", teacherId=" + teacherId +
                '}';
    }
}
