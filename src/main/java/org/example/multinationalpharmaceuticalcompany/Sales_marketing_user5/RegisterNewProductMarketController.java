package org.example.multinationalpharmaceuticalcompany.Sales_marketing_user5;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.multinationalpharmaceuticalcompany.Sales_marketing_user5.ModelClass.Product;


import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class RegisterNewProductMarketController
{
    @javafx.fxml.FXML
    private DatePicker date;
    @javafx.fxml.FXML
    private TableColumn<Product, String> categoryCl;
    @javafx.fxml.FXML
    private TextField quantity;
    @javafx.fxml.FXML
    private TableColumn<Product, String> dateCl;
    @javafx.fxml.FXML
    private TableView<Product> tableView;
    @javafx.fxml.FXML
    private TableColumn<Product, String> priceCl;
    @javafx.fxml.FXML
    private TableColumn<Product, String> describeCl;
    @javafx.fxml.FXML
    private TableColumn<Product, String> nameCl;
    @javafx.fxml.FXML
    private TextField productName;
    @javafx.fxml.FXML
    private TableColumn<Product, String> quantityCl;
    @javafx.fxml.FXML
    private TextField price;
    @javafx.fxml.FXML
    private TextArea describe;
    @javafx.fxml.FXML
    private TextField category;

    private ArrayList<Product> products = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        nameCl.setCellValueFactory(new PropertyValueFactory<>("productName"));
        quantityCl.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        priceCl.setCellValueFactory(new PropertyValueFactory<>("price"));
        describeCl.setCellValueFactory(new PropertyValueFactory<>("description"));
        dateCl.setCellValueFactory(new PropertyValueFactory<>("date"));
        categoryCl.setCellValueFactory(new PropertyValueFactory<>("category"));
    }

    @javafx.fxml.FXML
    public void loadButton(ActionEvent actionEvent) {
        try (ObjectInputStream input = new ObjectInputStream( new FileInputStream("product.bin"))) {
            tableView.getItems().clear();
            int size = input.readInt();
            for (int i = 0; i < size; i++) {
                Product product = (Product) input.readObject();
                tableView.getItems().add(product);
            }
        } catch (IOException e) {
            System.out.println("Error reading file");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void saveButton(ActionEvent actionEvent) {
        if (productName.getText().isEmpty() || quantity.getText().isEmpty() || price.getText().isEmpty() || describe.getText().isEmpty() || category.getText().isEmpty()
        || date.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Empty Field");
            alert.setContentText("Please fill all the fields");
            alert.showAndWait();
            return;
        }
        LocalDate local = date.getValue();
        if (local.isBefore(LocalDate.now()) || local.isEqual(LocalDate.now())) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Invalid Date");
            alert.setContentText("Date cannot be in the past");
            alert.showAndWait();
            return;
        }

        Product product = new Product(productName.getText(), quantity.getText(), price.getText(), describe.getText(), date.getValue().toString(), category.getText());
        products.add(product);

        try (ObjectOutputStream output = new ObjectOutputStream( new FileOutputStream("product.bin"))) {
            output.writeInt(products.size());
            for (Product e : products) {
                output.writeObject(e);
            }

            Alert success = new Alert(Alert.AlertType.INFORMATION);
            success.setTitle("Success");
            success.setHeaderText("Success");
            success.setContentText("Account Created Successfully!");
            success.showAndWait();

        } catch (IOException e) {
            System.out.println("Error reading file");
        }

        productName.clear();
        quantity.clear();
        price.clear();
        describe.clear();
        category.clear();
        date.setValue(null);
    }
}