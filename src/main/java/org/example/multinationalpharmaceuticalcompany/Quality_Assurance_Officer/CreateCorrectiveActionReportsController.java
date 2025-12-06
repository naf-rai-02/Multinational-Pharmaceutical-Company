package org.example.multinationalpharmaceuticalcompany.Quality_Assurance_Officer;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.multinationalpharmaceuticalcompany.Quality_Assurance_Officer.ModelClass.ActionSteps;

import java.time.LocalDate;
import java.util.ArrayList;

public class CreateCorrectiveActionReportsController
{
    @javafx.fxml.FXML
    private DatePicker date;
    @javafx.fxml.FXML
    private TextField issueId;
    @javafx.fxml.FXML
    private TextField search;
    @javafx.fxml.FXML
    private TableColumn<ActionSteps, String> idCl;
    @javafx.fxml.FXML
    private TableColumn<ActionSteps, String> titleCl;
    @javafx.fxml.FXML
    private TableColumn<ActionSteps, String> dateCl;
    @javafx.fxml.FXML
    private TableView<ActionSteps> tableView;
    @javafx.fxml.FXML
    private TextArea details;
    @javafx.fxml.FXML
    private TextField title;
    @javafx.fxml.FXML
    private TableColumn<ActionSteps, String> detailsCl;

    private ArrayList<ActionSteps> actionSteps = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        idCl.setCellValueFactory(new PropertyValueFactory<>("issueID"));
        titleCl.setCellValueFactory(new PropertyValueFactory<>("title"));
        dateCl.setCellValueFactory(new PropertyValueFactory<>("date"));
        detailsCl.setCellValueFactory(new PropertyValueFactory<>("actionSteps"));
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
        for (ActionSteps e : tableView.getItems()) {
            if (e.getIssueID().equalsIgnoreCase(search.getText()) || e.getTitle().equalsIgnoreCase(search.getText()) || e.getDate().equalsIgnoreCase(search.getText()) || e.getActionSteps().equalsIgnoreCase(search.getText())) {
                tableView.getItems().add(e);
            }
        }
    }

    @javafx.fxml.FXML
    public void saveButton(ActionEvent actionEvent) {
        if (title.getText().isEmpty() || details.getText().isEmpty() || date.getValue() == null || issueId.getText().isEmpty()) {
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

        for (ActionSteps e : actionSteps) {
            if (e.getIssueID().equals(issueId.getText())) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("Issue ID Already Exists");
                alert.setContentText("Please enter a different Issue ID");
                alert.showAndWait();
                return;
            }
        }

        ActionSteps actionSteps = new ActionSteps(issueId.getText(), title.getText(), date.getValue().toString(), details.getText());
        tableView.getItems().add(actionSteps);
        this.actionSteps.add(actionSteps);

        Alert success = new Alert(Alert.AlertType.INFORMATION);
        success.setTitle("Success");
        success.setHeaderText("Success");
        success.setContentText("Action Steps Saved Successfully");
        success.showAndWait();

        title.clear();
        details.clear();
        date.setValue(null);
        issueId.clear();
        tableView.refresh();
    }

    @javafx.fxml.FXML
    public void resetButton(ActionEvent actionEvent) {
        tableView.getItems().clear();
        tableView.getItems().addAll(actionSteps);
    }
}