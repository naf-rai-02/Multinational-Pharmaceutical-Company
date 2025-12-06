package org.example.multinationalpharmaceuticalcompany.Quality_Assurance_Officer;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.multinationalpharmaceuticalcompany.Quality_Assurance_Officer.ModelClass.NewProtocol;

import java.time.LocalDate;
import java.util.ArrayList;

public class CreateNewTestProtocolController
{
    @javafx.fxml.FXML
    private DatePicker date;
    @javafx.fxml.FXML
    private TextField search;
    @javafx.fxml.FXML
    private TextArea instruction;
    @javafx.fxml.FXML
    private ComboBox<String> typeCB;
    @javafx.fxml.FXML
    private TableColumn<NewProtocol, String> dateCl;
    @javafx.fxml.FXML
    private TableColumn<NewProtocol, String> instructionCl;
    @javafx.fxml.FXML
    private TextField name;
    @javafx.fxml.FXML
    private TableView<NewProtocol> tableView;
    @javafx.fxml.FXML
    private TableColumn<NewProtocol, String> nameCl;
    @javafx.fxml.FXML
    private TableColumn<NewProtocol, String> typeCl;

    private ArrayList<NewProtocol> protocols = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        typeCB.getItems().addAll("Test", "Inspection", "Maintenance", "Calibration");

        nameCl.setCellValueFactory(new PropertyValueFactory<>("protocolName"));
        typeCl.setCellValueFactory(new PropertyValueFactory<>("protocolType"));
        dateCl.setCellValueFactory(new PropertyValueFactory<>("protocolDate"));
        instructionCl.setCellValueFactory(new PropertyValueFactory<>("protocolDescription"));
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
        for (NewProtocol protocol : protocols) {
            if (protocol.getProtocolName().equalsIgnoreCase(search.getText()) || protocol.getProtocolType().equalsIgnoreCase(search.getText())
            || protocol.getProtocolDate().equalsIgnoreCase(search.getText()) || protocol.getProtocolDescription().equalsIgnoreCase(search.getText())) {
                tableView.getItems().add(protocol);
            }
        }
    }

    @javafx.fxml.FXML
    public void saveButton(ActionEvent actionEvent) {
        if (name.getText().isEmpty() || instruction.getText().isEmpty() || typeCB.getValue() == null || date.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Empty Fields");
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

        NewProtocol newProtocol = new NewProtocol(name.getText(), instruction.getText(), typeCB.getValue(), date.getValue().toString());
        tableView.getItems().add(newProtocol);
        protocols.add(newProtocol);

        Alert success = new Alert(Alert.AlertType.INFORMATION);
        success.setTitle("Success");
        success.setHeaderText("Success");
        success.setContentText("New Protocol Saved Successfully");
        success.showAndWait();

        name.clear();
        instruction.clear();
        date.setValue(null);
        typeCB.setValue(null);
        tableView.refresh();
    }

    @javafx.fxml.FXML
    public void resetButton(ActionEvent actionEvent) {
        tableView.getItems().clear();
        tableView.getItems().addAll(protocols);
    }
}