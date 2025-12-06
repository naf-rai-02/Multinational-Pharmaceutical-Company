package org.example.multinationalpharmaceuticalcompany.ResearchScientist.ModelClass;


public class RecordExp {
    private String expName;
    private String expDate;
    private String equName;
    private String description;
    private String dangerLevel;

    public RecordExp(String expName, String expDate, String equName, String description, String dangerLevel) {
        this.expName = expName;
        this.expDate = expDate;
        this.equName = equName;
        this.description = description;
        this.dangerLevel = dangerLevel;
    }

    public String getExpName() {
        return expName;
    }

    public void setExpName(String expName) {
        this.expName = expName;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getEquName() {
        return equName;
    }

    public void setEquName(String equName) {
        this.equName = equName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDangerLevel() {
        return dangerLevel;
    }

    public void setDangerLevel(String dangerLevel) {
        this.dangerLevel = dangerLevel;
    }
}
