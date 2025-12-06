package org.example.multinationalpharmaceuticalcompany.Administrator.ModelClass;

import java.io.Serializable;

public class Employee implements Serializable {
    private String name;
    private String role;
    private String department;
    private String activeDeactive;
    private String accessLevel;
    private String workingShift;
    private String accountType;
    private String joinDate;

    public Employee(String name, String role, String department, String activeDeactive, String workingShift, String accessLevel, String accountType, String joinDate) {
        this.name = name;
        this.role = role;
        this.department = department;
        this.activeDeactive = activeDeactive;
        this.workingShift = workingShift;
        this.accessLevel = accessLevel;
        this.accountType = accountType;
        this.joinDate = joinDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getActiveDeactive() {
        return activeDeactive;
    }

    public void setActiveDeactive(String activeDeactive) {
        this.activeDeactive = activeDeactive;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    public String getWorkingShift() {
        return workingShift;
    }

    public void setWorkingShift(String workingShift) {
        this.workingShift = workingShift;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }
}
