package org.example.multinationalpharmaceuticalcompany.Administrator.ModelClass;

public class SystemAccess {
    private String access;
    private String name;
    private String description;
    private String role;

    public SystemAccess(String access, String name, String description, String role) {
        this.access = access;
        this.name = name;
        this.description = description;
        this.role = role;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
