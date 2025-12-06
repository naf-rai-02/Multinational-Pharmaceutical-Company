package org.example.multinationalpharmaceuticalcompany.Regulatory_officer_user6;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.multinationalpharmaceuticalcompany.Regulatory_officer_user6.ModelClass.Register;

import java.time.LocalDate;
import java.util.ArrayList;

public class RegisterComplianceRequirementController
{
    @javafx.fxml.FXML
    private DatePicker date;
    @javafx.fxml.FXML
    private TableColumn<Register, String> descriptionCl;
    @javafx.fxml.FXML
    private TextField search;
    @javafx.fxml.FXML
    private TextField role;
    @javafx.fxml.FXML
    private TableColumn<Register, String> dateCl;
    @javafx.fxml.FXML
    private TableColumn<Register, String> regionCl;
    @javafx.fxml.FXML
    private TextField name;
    @javafx.fxml.FXML
    private TableColumn<Register, String> roleCl;
    @javafx.fxml.FXML
    private TextArea description;
    @javafx.fxml.FXML
    private TableView<Register> tableView;
    @javafx.fxml.FXML
    private TableColumn<Register, String> nameCl;
    @javafx.fxml.FXML
    private ComboBox<String> region;

    private ArrayList<Register> registers;

    @javafx.fxml.FXML
    public void initialize() {
        region.getItems().addAll("Dhaka", "Chittagong", "Khulna", "Rajshahi", "Barisal", "Sylhet", "Rangpur", "Mymensingh");

        nameCl.setCellValueFactory(new PropertyValueFactory<>("name"));
        roleCl.setCellValueFactory(new PropertyValueFactory<>("role"));
        regionCl.setCellValueFactory(new PropertyValueFactory<>("region"));
        dateCl.setCellValueFactory(new PropertyValueFactory<>("date"));
        descriptionCl.setCellValueFactory(new PropertyValueFactory<>("description"));
    }

    @javafx.fxml.FXML
    public void searchButton(ActionEvent actionEvent) {
        if (search.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a name to search.");
            alert.showAndWait();
            return;
        }
        tableView.getItems().clear();
        for (Register register : registers) {
            if (register.getName().equalsIgnoreCase(search.getText()) || register.getRole().equalsIgnoreCase(search.getText())
            || register.getRegion().equalsIgnoreCase(search.getText()) || register.getDate().equalsIgnoreCase(search.getText())
                    || register.getDescription().equalsIgnoreCase(search.getText())) {
                tableView.getItems().add(register);
                return;
            }
        }
    }

    @javafx.fxml.FXML
    public void saveData(ActionEvent actionEvent) {
        if (name.getText().isEmpty() || role.getText().isEmpty() || region.getValue() == null || date.getValue() == null || description.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all the fields.");
            alert.showAndWait();
            return;
        }

        LocalDate localDate = date.getValue();
        if (localDate.isBefore(LocalDate.now()) || localDate.isEqual(LocalDate.now())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please select a future date.");
            alert.showAndWait();
            return;
        }

        Register register = new Register(name.getText(), role.getText(), region.getValue(), date.getValue().toString(), description.getText());
        tableView.getItems().add(register);
        registers.add(register);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Data saved successfully.");
        alert.showAndWait();

        name.clear();
        role.clear();
        region.setValue(null);
        date.setValue(null);
        description.clear();
    }

    @javafx.fxml.FXML
    public void resetButton(ActionEvent actionEvent) {
        tableView.getItems().clear();
        tableView.getItems().addAll(registers);
    }
}