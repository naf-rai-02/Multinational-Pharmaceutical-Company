package org.example.multinationalpharmaceuticalcompany.Quality_Assurance_Officer.ModelClass;

public class ActionSteps {
    private String issueID;
    private String title;
    private String actionSteps;
    private String date;

    public ActionSteps(String issueID, String title, String actionSteps, String date) {
        this.issueID = issueID;
        this.title = title;
        this.actionSteps = actionSteps;
        this.date = date;
    }

    public String getIssueID() {
        return issueID;
    }

    public void setIssueID(String issueID) {
        this.issueID = issueID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getActionSteps() {
        return actionSteps;
    }

    public void setActionSteps(String actionSteps) {
        this.actionSteps = actionSteps;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
