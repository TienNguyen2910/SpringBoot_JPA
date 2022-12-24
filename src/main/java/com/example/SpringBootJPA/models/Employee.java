package com.example.SpringBootJPA.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmployeeId")
    private int employeeId;
    @Column(name ="UserName")
    private String userName;
    @Column(name = "DateOfBirth")
    private Date dateOfBirth;
    @Column(name = "Email")
    private String email;
    @Column(name = "Password")
    private String password;
    @ManyToOne
    @JoinColumn(name = "departmentId")
    private Department department;
    public Employee(){}
    public Employee(String userName, Date dateOfBirth, String email, String password, Department department) {
        this.userName = userName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.password = password;
        this.department = department;
    }


    public int getEmployeeId() {
        return employeeId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
