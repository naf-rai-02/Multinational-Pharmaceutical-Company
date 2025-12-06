package org.example.multinationalpharmaceuticalcompany.ResearchScientist;

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
            Parent root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("/org/example/multinationalpharmaceuticalcompany/ResearchSciencetistFxml/RecordLabExperiment.fxml")));
            borderPane.setCenter(root);
        } catch (IOException ignored) {}
    }

    @javafx.fxml.FXML
    public void researchButton(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("/org/example/multinationalpharmaceuticalcompany/ResearchSciencetistFxml/RegisterNewResearchProject.fxml")));
            borderPane.setCenter(root);
        } catch (IOException ignored) {}
    }

    @javafx.fxml.FXML
    public void requestButton(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("/org/example/multinationalpharmaceuticalcompany/ResearchSciencetistFxml/RequestforRequiredEquipment.fxml")));
            borderPane.setCenter(root);
        } catch (IOException ignored) {}
    }

    @javafx.fxml.FXML
    public void recordButton(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("/org/example/multinationalpharmaceuticalcompany/ResearchSciencetistFxml/RecordLabExperiment.fxml")));
            borderPane.setCenter(root);
        } catch (IOException ignored) {}
    }

    @javafx.fxml.FXML
    public void logOutButton(ActionEvent actionEvent) {
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