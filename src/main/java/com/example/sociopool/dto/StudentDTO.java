package com.example.sociopool.dto;

import java.util.Date;

public class StudentDTO {
    private String name;
    private String roll;
    private String class1;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getClass1() {
        return class1;
    }

    public void setClass1(String class1) {
        this.class1 = class1;
    }

    @Override
    public String toString() {
        return "UserProfileDTO{" +
                "name='" + name + '\'' +
                ", roll='" + roll + '\'' +
                ", class1='" + class1 + '\'' +
                '}';
    }
}
