package org.example.multinationalpharmaceuticalcompany.ResearchScientist;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.multinationalpharmaceuticalcompany.ResearchScientist.ModelClass.RegisterProject;


import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class RegisterNewResearchProjectController
{
    @javafx.fxml.FXML
    private DatePicker date;
    @javafx.fxml.FXML
    private TableColumn<RegisterProject, String> dateCl;
    @javafx.fxml.FXML
    private TextField name;
    @javafx.fxml.FXML
    private TableView<RegisterProject> tableView;
    @javafx.fxml.FXML
    private TextField staffNumber;
    @javafx.fxml.FXML
    private TableColumn<RegisterProject, String> nameCl;
    @javafx.fxml.FXML
    private TableColumn<RegisterProject, String> staffCl;
    @javafx.fxml.FXML
    private TableColumn<RegisterProject, String> objectCl;
    @javafx.fxml.FXML
    private TextArea objective;

    private RegisterProject registerProject;
    private ArrayList<RegisterProject> registerProjectsList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        nameCl.setCellValueFactory(new PropertyValueFactory<>("projectName"));
        staffCl.setCellValueFactory(new PropertyValueFactory<>("staffNumber"));
        objectCl.setCellValueFactory(new PropertyValueFactory<>("projectDescription"));
        dateCl.setCellValueFactory(new PropertyValueFactory<>("projectDate"));
    }

    @javafx.fxml.FXML
    public void savebutton(ActionEvent actionEvent) {
        if (name.getText().isEmpty() || staffNumber.getText().isEmpty() || objective.getText().isEmpty() || date.getValue() == null) {
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

        registerProject = new RegisterProject(name.getText(), objective.getText(), date.getValue().toString(), staffNumber.getText());
        registerProjectsList.add(registerProject);

        try (ObjectOutputStream output = new ObjectOutputStream( new FileOutputStream("registerProject.bin"))) {
            output.writeInt(registerProjectsList.size());
            for (RegisterProject e : registerProjectsList) {
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
    }

    @javafx.fxml.FXML
    public void tableLoadButton(ActionEvent actionEvent) {
        try (ObjectInputStream input = new ObjectInputStream( new FileInputStream("registerProject.bin"))) {
            tableView.getItems().clear();
            int size = input.readInt();
            for (int i = 0; i < size; i++) {
                RegisterProject registerProject = (RegisterProject) input.readObject();
                tableView.getItems().add(registerProject);
            }
        } catch (IOException e) {
            System.out.println("Error reading file");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}