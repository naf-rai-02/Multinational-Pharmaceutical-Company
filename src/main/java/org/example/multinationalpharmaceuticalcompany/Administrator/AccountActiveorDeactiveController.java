package org.example.multinationalpharmaceuticalcompany.Administrator;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.multinationalpharmaceuticalcompany.Administrator.ModelClass.Employee;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class AccountActiveorDeactiveController
{
    @javafx.fxml.FXML
    private TableColumn<Employee, String> accessLevelCl;
    @javafx.fxml.FXML
    private TableColumn<Employee, String> departmentCl;
    @javafx.fxml.FXML
    private TableColumn<Employee, String> accountTypeCl;
    @javafx.fxml.FXML
    private TableColumn<Employee, String> joiningDateCl;
    @javafx.fxml.FXML
    private TextField search;
    @javafx.fxml.FXML
    private ComboBox<String> employeeNameCB;
    @javafx.fxml.FXML
    private TableColumn<Employee, String> activeTypeCl;
    @javafx.fxml.FXML
    private TableColumn<Employee, String> roleCl;
    @javafx.fxml.FXML
    private TableView<Employee> tableView;
    @javafx.fxml.FXML
    private TableColumn<Employee, String> workingShiftCl;
    @javafx.fxml.FXML
    private ComboBox<String> activeDeactiveCB;
    @javafx.fxml.FXML
    private TableColumn<Employee, String> nameCl;


    @javafx.fxml.FXML
    public void initialize() {
        activeDeactiveCB.getItems().addAll("Active", "Deactive");

        nameCl.setCellValueFactory(new PropertyValueFactory<>("name"));
        roleCl.setCellValueFactory(new PropertyValueFactory<>("role"));
        workingShiftCl.setCellValueFactory(new PropertyValueFactory<>("workingShift"));
        activeTypeCl.setCellValueFactory(new PropertyValueFactory<>("activeDeactive"));
        accountTypeCl.setCellValueFactory(new PropertyValueFactory<>("accountType"));
        joiningDateCl.setCellValueFactory(new PropertyValueFactory<>("joinDate"));
        departmentCl.setCellValueFactory(new PropertyValueFactory<>("department"));
        accessLevelCl.setCellValueFactory(new PropertyValueFactory<>("accessLevel"));
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
            for (Employee emp : tableView.getItems()) {
                if (emp.getName().toLowerCase().contains(search.getText().toLowerCase()) || emp.getRole().toLowerCase().contains(search.getText().toLowerCase()
                ) || emp.getDepartment().toLowerCase().contains(search.getText().toLowerCase()) || emp.getActiveDeactive().toLowerCase().contains(search.getText().toLowerCase())
                || emp.getAccountType().toLowerCase().contains(search.getText().toLowerCase()) || emp.getJoinDate().toLowerCase().contains(search.getText().toLowerCase())
                || emp.getWorkingShift().toLowerCase().contains(search.getText().toLowerCase()) || emp.getAccessLevel().toLowerCase().contains(search.getText().toLowerCase())) {
                    tableView.getItems().add(emp);
                }
            }
        }
    }

    @javafx.fxml.FXML
    public void refreshButton(ActionEvent actionEvent) {
        tableView.refresh();
    }

    @javafx.fxml.FXML
    public void loadTableButton(ActionEvent actionEvent) {
        try (ObjectInputStream input = new ObjectInputStream( new FileInputStream("employee.bin"))) {
            tableView.getItems().clear();
            int size = input.readInt();
            for (int i = 0; i < size; i++) {
                Employee employee = (Employee) input.readObject();
                employeeNameCB.getItems().add(employee.getName());
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
        employeeNameCB.getItems().clear();
        loadTableButton(actionEvent);
    }

    @javafx.fxml.FXML
    public void updateInfoButton(ActionEvent actionEvent) {
        if (activeDeactiveCB.getValue() == null || employeeNameCB.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Empty Field");
            alert.setContentText("Please select an option");
            alert.showAndWait();
            return;
        }
        for (Employee emp : tableView.getItems()) {
            if (emp.getName().equals(employeeNameCB.getValue())) {
                emp.setActiveDeactive(activeDeactiveCB.getValue());
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText("Update Successful");
                alert.setContentText("Employee status updated successfully");
                alert.showAndWait();
                return;
            }
        }
    }
}