package org.example.multinationalpharmaceuticalcompany.Quality_Assurance_Officer.ModelClass;

import java.io.Serializable;

public class Inspection implements Serializable {
    private String batchID;
    private String productName;
    private String inspectionDate;
    private String inspectionDescription;
    private String inspectionAction;
    private String inspectionStatus;

    public Inspection(String batchID, String productName, String inspectionDate, String inspectionDescription, String inspectionAction, String inspectionStatus) {
        this.batchID = batchID;
        this.productName = productName;
        this.inspectionDate = inspectionDate;
        this.inspectionDescription = inspectionDescription;
        this.inspectionAction = inspectionAction;
        this.inspectionStatus = inspectionStatus;
    }

    public String getBatchID() {
        return batchID;
    }

    public void setBatchID(String batchID) {
        this.batchID = batchID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(String inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    public String getInspectionDescription() {
        return inspectionDescription;
    }

    public void setInspectionDescription(String inspectionDescription) {
        this.inspectionDescription = inspectionDescription;
    }

    public String getInspectionAction() {
        return inspectionAction;
    }

    public void setInspectionAction(String inspectionAction) {
        this.inspectionAction = inspectionAction;
    }

    public String getInspectionStatus() {
        return inspectionStatus;
    }

    public void setInspectionStatus(String inspectionStatus) {
        this.inspectionStatus = inspectionStatus;
    }
}
