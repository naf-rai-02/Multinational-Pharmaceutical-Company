package org.example.multinationalpharmaceuticalcompany.Regulatory_officer_user6.ModelClass;

import java.io.Serializable;

public class RegionProfile implements Serializable {
    private String regionName;
    private String authorityLevel;
    private String rules;
    private String date;

    public RegionProfile(String regionName, String authorityLevel, String rules, String date) {
        this.regionName = regionName;
        this.authorityLevel = authorityLevel;
        this.rules = rules;
        this.date = date;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getAuthorityLevel() {
        return authorityLevel;
    }

    public void setAuthorityLevel(String authorityLevel) {
        this.authorityLevel = authorityLevel;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
