package org.example.multinationalpharmaceuticalcompany.Regulatory_officer_user6.ModelClass;

import java.io.Serializable;

public class DelayReson implements Serializable {
    private String submissionID;
    private String submissionName;
    private String date;
    private String region;
    private String reasons;

    public DelayReson(String submissionID, String submissionName, String date, String region, String reasons) {
        this.submissionID = submissionID;
        this.submissionName = submissionName;
        this.date = date;
        this.region = region;
        this.reasons = reasons;
    }

    public String getSubmissionID() {
        return submissionID;
    }

    public void setSubmissionID(String submissionID) {
        this.submissionID = submissionID;
    }

    public String getSubmissionName() {
        return submissionName;
    }

    public void setSubmissionName(String submissionName) {
        this.submissionName = submissionName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getReasons() {
        return reasons;
    }

    public void setReasons(String reasons) {
        this.reasons = reasons;
    }
}
