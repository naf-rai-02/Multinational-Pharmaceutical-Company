package org.example.multinationalpharmaceuticalcompany.ResearchScientist;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import org.example.multinationalpharmaceuticalcompany.ResearchScientist.ModelClass.RequestInfo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class RequestforRequiredEquipmentController
{
    @javafx.fxml.FXML
    private DatePicker date;
    @javafx.fxml.FXML
    private TextField qunatity;
    @javafx.fxml.FXML
    private ToggleGroup level;
    @javafx.fxml.FXML
    private TextField name;
    @javafx.fxml.FXML
    private TextArea object;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void sendButton(ActionEvent actionEvent) {
        if (name.getText().isEmpty() || object.getText().isEmpty() || qunatity.getText().isEmpty() || date.getValue() == null || level.getSelectedToggle() == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Empty Fields");
            alert.setContentText("Please fill all the fields");
            alert.showAndWait();
            return;
        }

        LocalDate time = date.getValue();
        if (time.isBefore(LocalDate.now()) || time.isEqual(LocalDate.now())) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Invalid Date");
            alert.setContentText("Date cannot be in the past");
            alert.showAndWait();
            return;
        }

        String priorty = ((RadioButton) level.getSelectedToggle()).getText();

        RequestInfo requestInfo = new RequestInfo(name.getText(), date.getValue().toString(), object.getText(), qunatity.getText(), priorty);
        ArrayList<RequestInfo> requests = new ArrayList<>();
        requests.add(requestInfo);

        try (ObjectOutputStream output = new ObjectOutputStream( new FileOutputStream("requests.bin"))) {
            output.writeInt(requests.size());
            for (RequestInfo e : requests) {
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
        object.clear();
        qunatity.clear();
        date.setValue(null);
        level.selectToggle(null);
    }
}