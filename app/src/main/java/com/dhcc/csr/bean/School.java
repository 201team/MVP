package com.dhcc.csr.bean;

import java.util.List;

/**
 * @Author: wlsh
 * @Date: 2019/7/30 11:35
 * @Description: 学校
 */
public class School {
    private String name;
    private List<Department> departments;

    public School() {
    }

    public School(String name, List<Department> departments) {
        this.name = name;
        this.departments = departments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}
