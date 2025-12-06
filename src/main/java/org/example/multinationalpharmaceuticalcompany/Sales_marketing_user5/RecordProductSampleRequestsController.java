package org.example.multinationalpharmaceuticalcompany.Sales_marketing_user5;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.multinationalpharmaceuticalcompany.Sales_marketing_user5.ModelClass.SampleProduct;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class RecordProductSampleRequestsController
{
    @javafx.fxml.FXML
    private DatePicker date;
    @javafx.fxml.FXML
    private TextField quantity;
    @javafx.fxml.FXML
    private TableColumn<SampleProduct, String> requestDetailsCl;
    @javafx.fxml.FXML
    private TextField sampleID;
    @javafx.fxml.FXML
    private TextArea requestDetails;
    @javafx.fxml.FXML
    private TableColumn<SampleProduct, String> dateCl;
    @javafx.fxml.FXML
    private TableView<SampleProduct> tableView;
    @javafx.fxml.FXML
    private TableColumn<SampleProduct, String> priceCl;
    @javafx.fxml.FXML
    private TableColumn<SampleProduct, String> nameCl;
    @javafx.fxml.FXML
    private ComboBox<String> priority;
    @javafx.fxml.FXML
    private TextField productName;
    @javafx.fxml.FXML
    private TableColumn<SampleProduct, String> simpleIdCl;
    @javafx.fxml.FXML
    private TableColumn<SampleProduct, String> quantitycl;
    @javafx.fxml.FXML
    private TextField price;
    @javafx.fxml.FXML
    private TableColumn<SampleProduct, String> priorityCl;

    private ArrayList<SampleProduct> sampleProducts;

    @javafx.fxml.FXML
    public void initialize() {
        priority.getItems().addAll("High", "Medium", "Low");

        simpleIdCl.setCellValueFactory(new PropertyValueFactory<>("sampleId"));
        nameCl.setCellValueFactory(new PropertyValueFactory<>("productName"));
        quantitycl.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        priceCl.setCellValueFactory(new PropertyValueFactory<>("price"));
        priorityCl.setCellValueFactory(new PropertyValueFactory<>("priority"));
        dateCl.setCellValueFactory(new PropertyValueFactory<>("date"));
        requestDetailsCl.setCellValueFactory(new PropertyValueFactory<>("details"));
    }

    @javafx.fxml.FXML
    public void loadTableData(ActionEvent actionEvent) {
        sampleProducts = new ArrayList<>();
        try (java.io.ObjectInputStream input = new java.io.ObjectInputStream(new java.io.FileInputStream("sampleProduct.bin"))) {
            int size = input.readInt();
            for (int i = 0; i < size; i++) {
                SampleProduct e = (SampleProduct) input.readObject();
                sampleProducts.add(e);
            }
            tableView.getItems().setAll(sampleProducts);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading file");
        }
    }

    @javafx.fxml.FXML
    public void saveButton(ActionEvent actionEvent) {
        if (sampleID.getText().isEmpty() || productName.getText().isEmpty() || price.getText().isEmpty() ||
                quantity.getText().isEmpty() || requestDetails.getText().isEmpty() || date.getValue() == null ||
                priority.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all fields.");
            alert.showAndWait();
            return;
        }

        LocalDate local = date.getValue();
        if (local.isBefore(LocalDate.now())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText(null);
            alert.setContentText("Date cannot be in the past.");
            alert.showAndWait();
            return;
        }

        SampleProduct sampleProduct = new SampleProduct(
                sampleID.getText(),
                productName.getText(),
                price.getText(),
                quantity.getText(),
                requestDetails.getText(),
                date.getValue().toString(),
                priority.getValue()
        );
        sampleProducts.add(sampleProduct);
        try (ObjectOutputStream output = new ObjectOutputStream( new FileOutputStream("sampleProduct.bin"))) {
            output.writeInt(sampleProducts.size());
            for (SampleProduct e : sampleProducts) {
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

        sampleID.clear();
        productName.clear();
        price.clear();
        quantity.clear();
        requestDetails.clear();
        date.setValue(null);
        priority.setValue(null);

    }

}