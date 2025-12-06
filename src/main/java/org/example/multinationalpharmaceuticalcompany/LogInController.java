package org.example.multinationalpharmaceuticalcompany;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LogInController
{
    @javafx.fxml.FXML
    private PasswordField password;
    @javafx.fxml.FXML
    private TextField userName;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void signUpButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("SignUp.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {}
    }

    @javafx.fxml.FXML
    public void logInButton(ActionEvent actionEvent) {
        if (userName.getText().isEmpty() || password.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Empty Fields");
            alert.setContentText("Please fill in all fields.");
            alert.showAndWait();
            return;
        }

        try (ObjectInputStream input = new ObjectInputStream( new FileInputStream("userData.bin"))) {
            int size = input.readInt();
            for (int i = 0; i < size; i++) {
                UserData user = (UserData) input.readObject();
                if (user.getName().equals(userName.getText()) && user.getPassword().equals(password.getText())) {
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(user.getFxmlPath()));
                    Parent root = fxmlLoader.load();
                    Scene scene = new Scene(root);
                    Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.show();
                    return;
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Invalid Credentials");
                    alert.setContentText("The username or password you entered is incorrect.");
                    alert.showAndWait();
                    return;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}