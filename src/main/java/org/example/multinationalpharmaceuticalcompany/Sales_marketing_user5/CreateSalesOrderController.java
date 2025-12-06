package org.example.multinationalpharmaceuticalcompany.Sales_marketing_user5;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.multinationalpharmaceuticalcompany.Sales_marketing_user5.ModelClass.Order;

import java.time.LocalDate;
import java.util.ArrayList;

public class CreateSalesOrderController
{
    @javafx.fxml.FXML
    private TableColumn<Order, String> descriptionCl;
    @javafx.fxml.FXML
    private TextField quantity;
    @javafx.fxml.FXML
    private TableColumn<Order, String> totalPriceCl;
    @javafx.fxml.FXML
    private TextField orderID;
    @javafx.fxml.FXML
    private TableColumn<Order, String> dateCl;
    @javafx.fxml.FXML
    private TextArea description;
    @javafx.fxml.FXML
    private TableView<Order> tableView;
    @javafx.fxml.FXML
    private TableColumn<Order, String> orderIdCl;
    @javafx.fxml.FXML
    private TextField search;
    @javafx.fxml.FXML
    private TableColumn<Order, String> quantityCl;
    @javafx.fxml.FXML
    private TextField price;
    @javafx.fxml.FXML
    private TextField name;
    @javafx.fxml.FXML
    private TableColumn<Order, String> productNameCl;
    @javafx.fxml.FXML
    private DatePicker date;

    private ArrayList<Order> orders;

    @javafx.fxml.FXML
    public void initialize() {
        productNameCl.setCellValueFactory(new PropertyValueFactory<>("productName"));
        orderIdCl.setCellValueFactory(new PropertyValueFactory<>("orderID"));
        quantityCl.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        totalPriceCl.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
        dateCl.setCellValueFactory(new PropertyValueFactory<>("orderDate"));
        descriptionCl.setCellValueFactory(new PropertyValueFactory<>("description"));
    }

    @javafx.fxml.FXML
    public void searchButton(ActionEvent actionEvent) {
        if (search.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please enter something to search.");
            alert.showAndWait();
            return;
        }
        tableView.getItems().clear();
        for (Order order : orders) {
            if (order.getOrderID().equalsIgnoreCase(search.getText()) || order.getProductName().equalsIgnoreCase(search.getText())
            || order.getDate().equalsIgnoreCase(search.getText()) || order.getDescription().equalsIgnoreCase(search.getText())
            || order.getQuantity().equalsIgnoreCase(search.getText()) || order.getTotalPrice().equalsIgnoreCase(search.getText())) {
                tableView.getItems().add(order);
                return;
            }
        }
    }

    @javafx.fxml.FXML
    public void saveButton(ActionEvent actionEvent) {
        if (orderID.getText().isEmpty() || name.getText().isEmpty() || quantity.getText().isEmpty() || price.getText().isEmpty() || date.getValue() == null || description.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all the fields.");
            alert.showAndWait();
            return;
        }
        int totalPrice = Integer.parseInt(quantity.getText()) * Integer.parseInt(price.getText());
        LocalDate orderDate = date.getValue();
        if (orderDate.isBefore(LocalDate.now())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Order date cannot be in the past.");
            alert.showAndWait();
            return;
        }

        for (Order ord : orders) {
            if (ord.getOrderID().equalsIgnoreCase(orderID.getText())) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Order ID already exists.");
                alert.showAndWait();
                return;
            }
        }

        Order order = new Order(orderID.getText(), name.getText(), quantity.getText(), String.valueOf(totalPrice), date.getValue().toString(), description.getText());
        tableView.getItems().add(order);
        orders.add(order);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Order saved successfully.");
        alert.showAndWait();

        orderID.clear();
        name.clear();
        quantity.clear();
        price.clear();
        date.setValue(null);
        description.clear();
    }

    @javafx.fxml.FXML
    public void resetButton(ActionEvent actionEvent) {
        tableView.getItems().clear();
        tableView.getItems().addAll(orders);
    }
}