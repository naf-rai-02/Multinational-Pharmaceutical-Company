package org.example.multinationalpharmaceuticalcompany.Regulatory_officer_user6;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import org.example.multinationalpharmaceuticalcompany.Regulatory_officer_user6.ModelClass.DelayReson;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class RecordReasonsSubmissionDelaysController
{
    @javafx.fxml.FXML
    private DatePicker date;
    @javafx.fxml.FXML
    private TextField submissionID;
    @javafx.fxml.FXML
    private TextField submissionName;
    @javafx.fxml.FXML
    private TextArea resons;
    @javafx.fxml.FXML
    private ComboBox<String> regionCB;

    private ArrayList<DelayReson> delayResons = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        regionCB.getItems().addAll("Dhaka", "Chittagong", "Khulna", "Rajshahi", "Barisal", "Sylhet", "Rangpur", "Mymensingh");
    }

    @javafx.fxml.FXML
    public void sendButton(ActionEvent actionEvent) {
        if (date.getValue() == null || submissionID.getText().isEmpty() || submissionName.getText().isEmpty()
        || resons.getText().isEmpty() || regionCB.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Incomplete Information");
            alert.setContentText("Please fill in all fields before submitting.");
            alert.showAndWait();
            return;
        }

        LocalDate local = date.getValue();
        if (local.isBefore(LocalDate.now())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid Date");
            alert.setContentText("The selected date cannot be in the past.");
            alert.showAndWait();
            return;
        }

        for (DelayReson dr : delayResons) {
            if (dr.getSubmissionID().equals(submissionID.getText())) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Duplicate Submission ID");
                alert.setContentText("A delay reason with this Submission ID already exists.");
                alert.showAndWait();
                return;
            }
        }

        DelayReson delayReson = new DelayReson(
                submissionID.getText(),
                submissionName.getText(),
                date.getValue().toString(),
                regionCB.getValue(),
                resons.getText()
        );
        delayResons.add(delayReson);

        try (ObjectOutputStream output = new ObjectOutputStream( new FileOutputStream("delayreson.bin"))) {
            for (DelayReson dr : delayResons) {
                if (dr.getSubmissionID().equals(submissionID.getText())) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Duplicate Submission ID");
                    alert.setContentText("A delay reason with this Submission ID already exists.");
                    alert.showAndWait();
                    return;
                }
            }
            output.writeInt(delayResons.size());
            for (DelayReson e : delayResons) {
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

        submissionID.clear();
        submissionName.clear();
        date.setValue(null);
        regionCB.setValue(null);
        resons.clear();

    }
}