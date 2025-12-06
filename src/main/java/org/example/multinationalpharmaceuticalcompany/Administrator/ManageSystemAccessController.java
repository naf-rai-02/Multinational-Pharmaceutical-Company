package org.example.multinationalpharmaceuticalcompany.Administrator;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import org.example.multinationalpharmaceuticalcompany.Administrator.ModelClass.SystemAccess;


public class ManageSystemAccessController
{
    @javafx.fxml.FXML
    private ToggleGroup acess;
    @javafx.fxml.FXML
    private TextField role;
    @javafx.fxml.FXML
    private TextField name;
    @javafx.fxml.FXML
    private TextArea description;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void saveButton(ActionEvent actionEvent) {
        if (role.getText().isEmpty() || name.getText().isEmpty() || description.getText().isEmpty() || acess.getSelectedToggle() == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Empty Fields");
            alert.setContentText("Please fill all the fields");
            alert.showAndWait();
        }

        SystemAccess systemAccess = new SystemAccess(acess.getSelectedToggle().getUserData().toString(), name.getText(), description.getText(), role.getText());

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("System Access Saved");
        alert.setContentText("System Access has been saved successfully");
        alert.showAndWait();

        role.clear();
        name.clear();
        description.clear();
        acess.selectToggle(null);
    }
}