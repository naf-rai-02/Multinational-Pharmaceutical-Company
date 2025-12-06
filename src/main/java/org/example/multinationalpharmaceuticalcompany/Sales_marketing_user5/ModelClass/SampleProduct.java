package org.example.multinationalpharmaceuticalcompany.Sales_marketing_user5.ModelClass;

import java.io.Serializable;

public class SampleProduct implements Serializable {
    private  String sampleId;
    private String productName;
    private String price;
    private String quantity;
    private String details;
    private String date;
    private String priority;

    public SampleProduct(String sampleId, String productName, String price, String quantity, String details, String date, String priority) {
        this.sampleId = sampleId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.details = details;
        this.date = date;
        this.priority = priority;
    }

    public String getSampleId() {
        return sampleId;
    }

    public void setSampleId(String sampleId) {
        this.sampleId = sampleId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
