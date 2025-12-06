package org.example.multinationalpharmaceuticalcompany;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SignUpController
{
    @javafx.fxml.FXML
    private ComboBox<String> userTpeCB;
    @javafx.fxml.FXML
    private TextField password;
    @javafx.fxml.FXML
    private TextField userName;

    private ArrayList<UserData> userslist = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        userTpeCB.getItems().addAll("Administrator", "Production Manager", "Research Scientist", "Regulatory Affairs Officer", "Quality Assurance Officer", "Sales Marketing Executive");
    }

    @javafx.fxml.FXML
    public void signUpButton(ActionEvent actionEvent) {
        if (userName.getText().isEmpty() || password.getText().isEmpty() || userTpeCB.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Incomplete Information");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all fields before signing up.");
            alert.showAndWait();
            return;
        }
        String fxmlPath = "";

        if (userTpeCB.getValue().equals("Administrator")) {
            fxmlPath = "/oop/cse211/AdministratorFxml/DashBoard.fxml";
        } else if (userTpeCB.getValue().equals("Production Manager")) {
            fxmlPath = "/oop/cse211/ProductionManagerFxml/DashBoard.fxml";
        } else if (userTpeCB.getValue().equals("Research Scientist")) {
            fxmlPath = "/oop/cse211/ResearchScientistFxml/DashBoard.fxml";
        } else if (userTpeCB.getValue().equals("Regulatory Affairs Officer")) {
            fxmlPath = "/org/example/multinationalpharmaceuticalcompany/Regulatory_officer_user6Fxml/DashBoard.fxml";
        } else if (userTpeCB.getValue().equals("Quality Assurance Officer")) {
            fxmlPath = "/oop/cse211/QualityAssuranceOfficerFxml/DashBoard.fxml";
        } else if (userTpeCB.getValue().equals("Sales Marketing Executive")) {
            fxmlPath = "/org/example/multinationalpharmaceuticalcompany/Sales_marketing_user5Fxml/DashBord.fxml";
        }

        UserData userData = new UserData(userName.getText(), password.getText(), userTpeCB.getValue(), fxmlPath);
        userslist.add(userData);

        try (ObjectOutputStream output = new ObjectOutputStream( new FileOutputStream("userData.bin"))) {
            output.writeInt(userslist.size());
            for (UserData e : userslist) {
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

        userName.clear();
        password.clear();
        userTpeCB.setValue(null);

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/oop/cse211/logIn.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {}
    }

    @javafx.fxml.FXML
    public void logInButton(ActionEvent actionEvent) {
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