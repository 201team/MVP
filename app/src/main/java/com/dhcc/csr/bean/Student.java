package com.dhcc.csr.bean;

/**
 * @Author: wlsh
 * @Date: 2019/7/30 11:34
 * @Description: 学生
 */
public class Student {
    private String name;
    private String school;

    public Student(){}
    public Student(String name, String school) {
        this.name = name;
        this.school = school;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
