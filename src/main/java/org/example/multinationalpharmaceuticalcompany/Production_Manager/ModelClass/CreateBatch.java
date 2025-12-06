package org.example.multinationalpharmaceuticalcompany.Production_Manager.ModelClass;

import java.io.Serializable;

public class CreateBatch implements Serializable {
    private String batchID;
    private String productName;
    private String quantity;
    private String priority;
    private String details;
    private String deliveryDate;
    private String status;

    public CreateBatch(String batchID, String productName, String quantity, String priority, String details, String deliveryDate, String status) {
        this.batchID = batchID;
        this.productName = productName;
        this.quantity = quantity;
        this.priority = priority;
        this.details = details;
        this.deliveryDate = deliveryDate;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
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

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
