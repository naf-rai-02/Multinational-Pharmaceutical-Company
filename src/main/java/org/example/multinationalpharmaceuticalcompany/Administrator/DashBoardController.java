package org.example.multinationalpharmaceuticalcompany.Administrator;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.example.multinationalpharmaceuticalcompany.HelloApplication;

import java.io.IOException;
import java.util.Objects;

public class DashBoardController
{
    @javafx.fxml.FXML
    private BorderPane borderPane;

    @javafx.fxml.FXML
    public void initialize() {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("/org/example/multinationalpharmaceuticalcompany/AdministratorFxml/ManageEmployee.fxml")));
            borderPane.setCenter(root);
        } catch (IOException ignored) {}
    }

    @javafx.fxml.FXML
    public void activeDeactivateButton(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("/org/example/multinationalpharmaceuticalcompany/AdministratorFxml/AccountActiveorDeactive.fxml")));
            borderPane.setCenter(root);
        } catch (IOException ignored) {}
    }

    @javafx.fxml.FXML
    public void manageEmployeeButton(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("/org/example/multinationalpharmaceuticalcompany/AdministratorFxml/ManageEmployee.fxml")));
            borderPane.setCenter(root);
        } catch (IOException ignored) {}
    }

    @javafx.fxml.FXML
    public void systemButton(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("/org/example/multinationalpharmaceuticalcompany/AdministratorFxml/ManageSystemAccess.fxml")));
            borderPane.setCenter(root);
        } catch (IOException ignored) {}
    }

    @javafx.fxml.FXML
    public void logoutButton(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("logIn.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {}
    }
}