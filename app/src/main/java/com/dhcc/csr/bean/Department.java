package com.dhcc.csr.bean;

import java.util.List;

/**
 * @Author: wlsh
 * @Date: 2019/7/30 11:35
 * @Description: 院系
 */
public class Department {
    private String name;
    private List<Student> students;

    public Department() {
    }

    public Department(String name, List<Student> students) {
        this.name = name;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
