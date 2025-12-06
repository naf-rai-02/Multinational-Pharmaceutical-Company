package org.example.multinationalpharmaceuticalcompany.ResearchScientist.ModelClass;

import java.io.Serializable;

public class RegisterProject implements Serializable {
    private String projectName;
    private String projectDescription;
    private String projectDate;
    private String staffNumber;

    public RegisterProject(String projectName, String projectDescription, String projectDate, String staffNumber) {
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.projectDate = projectDate;
        this.staffNumber = staffNumber;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getProjectDate() {
        return projectDate;
    }

    public void setProjectDate(String projectDate) {
        this.projectDate = projectDate;
    }

    public String getStaffNumber() {
        return staffNumber;
    }

    public void setStaffNumber(String staffNumber) {
        this.staffNumber = staffNumber;
    }
}
