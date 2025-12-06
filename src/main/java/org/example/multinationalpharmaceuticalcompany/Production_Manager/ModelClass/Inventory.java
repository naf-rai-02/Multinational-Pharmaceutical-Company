package org.example.multinationalpharmaceuticalcompany.Production_Manager.ModelClass;

public class Inventory {
    private String productID;
    private String productName;
    private String quantity;
    private String status;
    private String storage;

    public Inventory(String productID, String productName, String quantity, String status, String storage) {
        this.productID = productID;
        this.productName = productName;
        this.quantity = quantity;
        this.status = status;
        this.storage = storage;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }
}
