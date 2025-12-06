package org.example.multinationalpharmaceuticalcompany;

import java.io.Serializable;

public class UserData implements Serializable {
    String name;
    String password;
    String userType;
    String fxmlPath;

    public UserData(String name, String password, String userType, String fxmlPath) {
        this.name = name;
        this.password = password;
        this.userType = userType;
        this.fxmlPath = fxmlPath;
    }

    public String getFxmlPath() {
        return fxmlPath;
    }

    public void setFxmlPath(String fxmlPath) {
        this.fxmlPath = fxmlPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
