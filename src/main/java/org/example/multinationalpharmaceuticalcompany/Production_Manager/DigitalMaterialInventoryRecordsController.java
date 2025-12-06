package org.example.multinationalpharmaceuticalcompany.Production_Manager;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.multinationalpharmaceuticalcompany.Production_Manager.ModelClass.Inventory;

import java.util.ArrayList;

public class DigitalMaterialInventoryRecordsController
{
    @javafx.fxml.FXML
    private TableColumn<Inventory, String> productIdCl;
    @javafx.fxml.FXML
    private TableColumn<Inventory, String> statusCl;
    @javafx.fxml.FXML
    private TextField search;
    @javafx.fxml.FXML
    private TextField quantity;
    @javafx.fxml.FXML
    private TextField productId;
    @javafx.fxml.FXML
    private TableColumn<Inventory, String> quantityCl;
    @javafx.fxml.FXML
    private ComboBox<String> statusCB;
    @javafx.fxml.FXML
    private TableView<Inventory> tableView;
    @javafx.fxml.FXML
    private TableColumn<Inventory, String> productNameCl;
    @javafx.fxml.FXML
    private ToggleGroup inventory;
    @javafx.fxml.FXML
    private TableColumn<Inventory, String> storageCl;
    @javafx.fxml.FXML
    private TextField productName;

    private ArrayList<Inventory> inventoryList = new ArrayList<>();
    private Inventory inventories;

    @javafx.fxml.FXML
    public void initialize() {
        statusCB.getItems().addAll("Available", "Not Available");

        productIdCl.setCellValueFactory(new PropertyValueFactory<>("productID"));
        statusCl.setCellValueFactory(new PropertyValueFactory<>("status"));
        quantityCl.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        productNameCl.setCellValueFactory(new PropertyValueFactory<>("productName"));
        storageCl.setCellValueFactory(new PropertyValueFactory<>("storage"));
    }

    @javafx.fxml.FXML
    public void searchButton(ActionEvent actionEvent) {
        if (search.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Empty Field");
            alert.setContentText("Please enter a valid search term");
            alert.showAndWait();
            return;
        }
        tableView.getItems().clear();
        for (Inventory inv : inventoryList) {
            if (inv.getProductID().equalsIgnoreCase(search.getText()) || inv.getProductName().equalsIgnoreCase(search.getText())
            || inv.getQuantity().equalsIgnoreCase(search.getText()) || inv.getStatus().equalsIgnoreCase(search.getText())
            || inv.getStorage().equalsIgnoreCase(search.getText())) {
                tableView.getItems().add(inv);
            }
        }
    }

    @javafx.fxml.FXML
    public void loadButton(ActionEvent actionEvent) {
        tableView.getItems().add(inventories);
    }

    @javafx.fxml.FXML
    public void saveButton(ActionEvent actionEvent) {
        if (productId.getText().isEmpty() || quantity.getText().isEmpty() || statusCB.getValue() == null || productName.getText().isEmpty() || inventory.getSelectedToggle() == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Empty Field");
            alert.setContentText("Please fill all the fields");
            alert.showAndWait();
            return;
        }

        for (Inventory inv : inventoryList) {
            if (inv.getProductID().equals(productId.getText())) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("Product ID Already Exists");
                alert.setContentText("Please enter a different Product ID");
                alert.showAndWait();
                return;
            }
        }

        String storage = ((RadioButton) inventory.getSelectedToggle()).getText();
        inventories = new Inventory(productId.getText(), productName.getText(), quantity.getText(), statusCB.getValue(), storage);
        inventoryList.add(inventories);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("Update Successful");
        alert.setContentText("Inventory updated successfully");
        alert.showAndWait();

        productId.clear();
        productName.clear();
        quantity.clear();
        statusCB.setValue(null);
        inventory.selectToggle(null);
    }

    @javafx.fxml.FXML
    public void resetButton(ActionEvent actionEvent) {
        tableView.getItems().clear();
        loadButton(actionEvent);
    }
}