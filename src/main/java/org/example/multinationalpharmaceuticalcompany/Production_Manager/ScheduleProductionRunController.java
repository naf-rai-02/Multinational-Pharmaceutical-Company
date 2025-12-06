package org.example.multinationalpharmaceuticalcompany.Production_Manager;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.multinationalpharmaceuticalcompany.Production_Manager.ModelClass.CreateBatch;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ScheduleProductionRunController
{
    @javafx.fxml.FXML
    private TableColumn<CreateBatch, String> statusCl;
    @javafx.fxml.FXML
    private TextField search;
    @javafx.fxml.FXML
    private TableColumn<CreateBatch, String> peoductNameCl;
    @javafx.fxml.FXML
    private TableColumn<CreateBatch, String> quantityCl;
    @javafx.fxml.FXML
    private TableColumn<CreateBatch, String> dateCl;
    @javafx.fxml.FXML
    private ComboBox<String> batchIdCB;
    @javafx.fxml.FXML
    private ComboBox<String> statusCB;
    @javafx.fxml.FXML
    private TableView<CreateBatch> tableView;
    @javafx.fxml.FXML
    private TableColumn<CreateBatch, String> batchIdCl;
    @javafx.fxml.FXML
    private TableColumn<CreateBatch, String> priorityCl;
    @javafx.fxml.FXML
    private TableColumn<CreateBatch, String> detailsCl;

    @javafx.fxml.FXML
    public void initialize() {
        statusCB.getItems().addAll("Completed", "Cancelled");

        batchIdCl.setCellValueFactory(new PropertyValueFactory<>("batchID"));
        peoductNameCl.setCellValueFactory(new PropertyValueFactory<>("productName"));
        quantityCl.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        dateCl.setCellValueFactory(new PropertyValueFactory<>("deliveryDate"));
        priorityCl.setCellValueFactory(new PropertyValueFactory<>("priority"));
        detailsCl.setCellValueFactory(new PropertyValueFactory<>("details"));
        statusCl.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    @javafx.fxml.FXML
    public void searchButton(ActionEvent actionEvent) {
        if (search.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Empty Field");
            alert.setContentText("Please enter a valid search term");
            alert.showAndWait();
        } else {
            tableView.getItems().clear();
            for (CreateBatch cb : tableView.getItems()) {
                if (cb.getBatchID().equalsIgnoreCase(search.getText()) || cb.getProductName().equalsIgnoreCase(search.getText())
                || cb.getQuantity().equalsIgnoreCase(search.getText()) || cb.getDeliveryDate().equalsIgnoreCase(search.getText())
                || cb.getPriority().equalsIgnoreCase(search.getText()) || cb.getDetails().equalsIgnoreCase(search.getText())
                || cb.getStatus().equalsIgnoreCase(search.getText())) {
                    tableView.getItems().add(cb);
                }
            }
        }
    }

    @javafx.fxml.FXML
    public void refreshButton(ActionEvent actionEvent) {
        tableView.refresh();
    }

    @javafx.fxml.FXML
    public void updateButton(ActionEvent actionEvent) {
        if (statusCB.getValue() == null || batchIdCB.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Empty Field");
            alert.setContentText("Please select an option");
            alert.showAndWait();
            return;
        }
        for (CreateBatch cb : tableView.getItems()) {
            if (cb.getBatchID().equals(batchIdCB.getValue())) {
                cb.setStatus(statusCB.getValue());
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText("Update Successful");
                alert.setContentText("Employee status updated successfully");
                alert.showAndWait();
                return;
            }
        }
    }

    @javafx.fxml.FXML
    public void loadTableButton(ActionEvent actionEvent) {
        try (ObjectInputStream input = new ObjectInputStream( new FileInputStream("batchcreate.bin"))) {
            tableView.getItems().clear();
            int size = input.readInt();
            for (int i = 0; i < size; i++) {
                CreateBatch employee = (CreateBatch) input.readObject();
                batchIdCB.getItems().add(employee.getBatchID());
                tableView.getItems().add(employee);
            }
        } catch (IOException e) {
            System.out.println("Error reading file");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void resetButton(ActionEvent actionEvent) {
        batchIdCB.getItems().clear();
        loadTableButton(actionEvent);
    }
}