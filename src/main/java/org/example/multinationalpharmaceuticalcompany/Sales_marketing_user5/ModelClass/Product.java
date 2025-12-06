package org.example.multinationalpharmaceuticalcompany.Sales_marketing_user5.ModelClass;

import java.io.Serializable;

public class Product implements Serializable {
    private String productName;
    private String category;
    private String quantity;
    private String price;
    private String description;
    private String date;

    public Product(String productName, String category, String quantity, String price, String description, String date) {
        this.productName = productName;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
        this.date = date;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
