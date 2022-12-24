package com.example.SpringBootJPA.models;

import jakarta.persistence.*;
import jakarta.persistence.Id;


import java.io.Serializable;


@Entity
public class Department implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DepartmentId")
    private int departmentId;
    @Column(name = "DepartmentName")
    private String departmentname;
    public Department(){}
    public Department(int departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentname = departmentName;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }

    public int getDepartmentId() {
        return departmentId;
    }
}
