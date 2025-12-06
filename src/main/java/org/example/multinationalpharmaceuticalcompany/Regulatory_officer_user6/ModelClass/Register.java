package org.example.multinationalpharmaceuticalcompany.Regulatory_officer_user6.ModelClass;

public class Register {
    private String name;
    private String role;
    private String region;
    private String date;
    private String description;

    public Register(String name, String role, String region, String date, String description) {
        this.name = name;
        this.role = role;
        this.region = region;
        this.date = date;
        this.description = description;
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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
