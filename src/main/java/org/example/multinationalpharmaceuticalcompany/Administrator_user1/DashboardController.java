package org.example.multinationalpharmaceuticalcompany.Administrator_user1;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.multinationalpharmaceuticalcompany.HelloApplication;

import java.io.IOException;
import java.util.EventObject;

public class DashboardController
{

    @FXML
    public void initialize() {
    }

    @FXML
    public void goal1(Event event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("production_manager_user3/goal1.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();


    }
}