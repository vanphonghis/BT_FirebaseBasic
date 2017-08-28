package com.example.vudinhai.bt_firebasebasic;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 08/25/2017.
 */

public class Student {
    String id;
    String name;

    public Student() {
    }

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
    public Map<String,Object> toMap(){

        Map<String,Object> student = new HashMap<>();
       student.put("id",id);
        student.put("name",name);
        // ;
        return student;


    }
}
