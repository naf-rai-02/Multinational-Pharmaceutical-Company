package org.example.multinationalpharmaceuticalcompany.Quality_Assurance_Officer;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import org.example.multinationalpharmaceuticalcompany.Quality_Assurance_Officer.ModelClass.Inspection;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class BatchInspectionTimelineController
{
    @javafx.fxml.FXML
    private DatePicker date;
    @javafx.fxml.FXML
    private TextArea details;
    @javafx.fxml.FXML
    private TextField batchid;
    @javafx.fxml.FXML
    private TextArea steps;
    @javafx.fxml.FXML
    private TextField productName;
    @javafx.fxml.FXML
    private ToggleGroup inspection;

    private ArrayList<Inspection> inspectionsList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void saveButton(ActionEvent actionEvent) {
        if (batchid.getText().isEmpty() || productName.getText().isEmpty() || date.getValue() == null || inspection.getSelectedToggle() == null
        || steps.getText().isEmpty() || details.getText().isEmpty()) {
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

        String type = ((RadioButton) inspection.getSelectedToggle()).getText();

        Inspection inspection = new Inspection(batchid.getText(), productName.getText(), date.getValue().toString(), details.getText(), steps.getText(), type);
        inspectionsList.add(inspection);

        try (ObjectOutputStream output = new ObjectOutputStream( new FileOutputStream("inspection.bin"))) {
            output.writeInt(inspectionsList.size());
            for (Inspection e : inspectionsList) {
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

        batchid.clear();
        productName.clear();
        date.setValue(null);
        steps.clear();
        details.clear();
    }
}