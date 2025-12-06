package org.example.multinationalpharmaceuticalcompany.Sales_marketing_user5.ModelClass;

public class Order {
    private String orderID;
    private String productName;
    private String quantity;
    private String totalPrice;
    private String date;
    private String description;

    public Order(String orderID, String productName, String quantity, String totalPrice, String date, String description) {
        this.orderID = orderID;
        this.productName = productName;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.date = date;
        this.description = description;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
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

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
