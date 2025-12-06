package org.example.multinationalpharmaceuticalcompany.ResearchScientist.ModelClass;

import java.io.Serializable;

public class RequestInfo implements Serializable {
    private String requestName;
    private String requestDate;
    private String requestDescription;
    private String quantity;
    private String priorityLevel;

    public RequestInfo(String requestName, String requestDate, String requestDescription, String quantity, String priorityLevel) {
        this.requestName = requestName;
        this.requestDate = requestDate;
        this.requestDescription = requestDescription;
        this.quantity = quantity;
        this.priorityLevel = priorityLevel;
    }

    public String getRequestName() {
        return requestName;
    }

    public void setRequestName(String requestName) {
        this.requestName = requestName;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public String getRequestDescription() {
        return requestDescription;
    }

    public void setRequestDescription(String requestDescription) {
        this.requestDescription = requestDescription;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(String priorityLevel) {
        this.priorityLevel = priorityLevel;
    }
}
