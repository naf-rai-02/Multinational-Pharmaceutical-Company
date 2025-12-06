package org.example.multinationalpharmaceuticalcompany.Administrator;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import org.example.multinationalpharmaceuticalcompany.Administrator.ModelClass.Employee;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class ManageEmployeeController
{
    @javafx.fxml.FXML
    private TextField role;
    @javafx.fxml.FXML
    private DatePicker joinDate;
    @javafx.fxml.FXML
    private TextField accessLevel;
    @javafx.fxml.FXML
    private ComboBox<String> accountTypeCB;
    @javafx.fxml.FXML
    private TextField name;
    @javafx.fxml.FXML
    private TextField department;
    @javafx.fxml.FXML
    private ComboBox<String> workingShiftCB;
    @javafx.fxml.FXML
    private ComboBox<String> activeDeactiveCB;

    private Employee employee;
    private ArrayList<Employee> employeesList = new ArrayList<>();


    @javafx.fxml.FXML
    public void initialize() {
        workingShiftCB.getItems().addAll("Morning", "Night");
        accountTypeCB.getItems().addAll("Admin", "Employee", "Pharmacist", "Receptionist", "Manager");
        activeDeactiveCB.getItems().addAll("Active", "Deactive");
    }

    @javafx.fxml.FXML
    public void saveInfoButton(ActionEvent actionEvent) {
        if (name.getText().isEmpty() || role.getText().isEmpty() || department.getText().isEmpty() || activeDeactiveCB.getValue() == null || workingShiftCB.getValue() == null || accessLevel.getText().isEmpty() || accountTypeCB.getValue() == null || joinDate.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Empty Fields");
            alert.setContentText("Please fill all the fields");
            alert.showAndWait();
            return;
        }

        LocalDate joiningDate = joinDate.getValue();
        if (joiningDate.isBefore(LocalDate.now()) || joiningDate.isEqual(LocalDate.now())) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Invalid Date");
            alert.setContentText("Joining date cannot be in the past");
            alert.showAndWait();
            return;
        }

        employee = new Employee(name.getText(), role.getText(), department.getText(), activeDeactiveCB.getValue().toString(), workingShiftCB.getValue().toString(), accessLevel.getText(), accountTypeCB.getValue().toString(), joinDate.getValue().toString());
        employeesList.add(employee);

        try (ObjectOutputStream output = new ObjectOutputStream( new FileOutputStream("employee.bin"))) {
            output.writeInt(employeesList.size());
            for (Employee e : employeesList) {
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

        name.clear();
        role.clear();
        department.clear();
        activeDeactiveCB.setValue(null);
        workingShiftCB.setValue(null);
        accessLevel.clear();
        accountTypeCB.setValue(null);
        joinDate.setValue(null);
    }
}