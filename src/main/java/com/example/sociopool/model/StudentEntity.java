package com.example.sociopool.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity(name = "register_student")
@Table(name = "register_student")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "name", nullable = false, length = 200)
    private String name;

    @Column(name = "roll", nullable = false, length = 200 ,unique = true)
    private String roll;

    @Column(name = "class", nullable = false, length = 200)
    private String class1;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
        return "StudentEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", roll='" + roll + '\'' +
                ", class1='" + class1 + '\'' +
                '}';
    }
}
