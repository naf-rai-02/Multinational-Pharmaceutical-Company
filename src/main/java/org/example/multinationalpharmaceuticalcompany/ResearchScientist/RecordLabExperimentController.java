package org.example.multinationalpharmaceuticalcompany.ResearchScientist;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.multinationalpharmaceuticalcompany.ResearchScientist.ModelClass.RecordExp;

import java.time.LocalDate;
import java.util.ArrayList;

public class RecordLabExperimentController
{
    @javafx.fxml.FXML
    private DatePicker date;
    @javafx.fxml.FXML
    private ComboBox<String> dangerCB;
    @javafx.fxml.FXML
    private TableColumn<RecordExp, String> equnameCl;
    @javafx.fxml.FXML
    private TableColumn<RecordExp, String> descriptionCl;
    @javafx.fxml.FXML
    private TextField expName;
    @javafx.fxml.FXML
    private TableColumn<RecordExp, String> expnameCl;
    @javafx.fxml.FXML
    private TableColumn<RecordExp, String> dateCl;
    @javafx.fxml.FXML
    private TextArea description;
    @javafx.fxml.FXML
    private TableView<RecordExp> tableView;
    @javafx.fxml.FXML
    private TextField search;
    @javafx.fxml.FXML
    private TextField equName;
    @javafx.fxml.FXML
    private TableColumn<RecordExp, String> dangerCl;

    private ArrayList<RecordExp> records = new ArrayList<>();


    @javafx.fxml.FXML
    public void initialize() {
        dangerCB.getItems().addAll("Low", "Medium", "High");

        expnameCl.setCellValueFactory(new PropertyValueFactory<>("expName"));
        dateCl.setCellValueFactory(new PropertyValueFactory<>("expDate"));
        dangerCl.setCellValueFactory(new PropertyValueFactory<>("dangerLevel"));
        descriptionCl.setCellValueFactory(new PropertyValueFactory<>("description"));
        equnameCl.setCellValueFactory(new PropertyValueFactory<>("equName"));
    }

    @javafx.fxml.FXML
    public void saveAndLoadButton(ActionEvent actionEvent) {
        if (expName.getText().isEmpty() || equName.getText().isEmpty() || description.getText().isEmpty() || dangerCB.getValue() == null || date.getValue() == null) {
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

        RecordExp recordExp = new RecordExp(expName.getText(), date.getValue().toString(), equName.getText(), description.getText(), dangerCB.getValue());
        tableView.getItems().add(recordExp);
        records.add(recordExp);

        Alert success = new Alert(Alert.AlertType.INFORMATION);
        success.setTitle("Success");
        success.setHeaderText("Success");
        success.setContentText("Experiment Record Saved Successfully");
        success.showAndWait();

        expName.clear();
        equName.clear();
        description.clear();
        dangerCB.setValue(null);
        date.setValue(null);
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
        for (RecordExp record : records) {
            if (record.getExpName().toLowerCase().contains(search.getText().toLowerCase()) || record.getEquName().toLowerCase().contains(search.getText().toLowerCase())
            || record.getDescription().toLowerCase().contains(search.getText().toLowerCase()) || record.getDangerLevel().toLowerCase().contains(search.getText().toLowerCase())
            || record.getExpDate().toLowerCase().contains(search.getText().toLowerCase())) {
                tableView.getItems().add(record);
            }
        }
    }

    @javafx.fxml.FXML
    public void resetButton(ActionEvent actionEvent) {
        tableView.getItems().clear();
        tableView.getItems().addAll(records);
    }
}