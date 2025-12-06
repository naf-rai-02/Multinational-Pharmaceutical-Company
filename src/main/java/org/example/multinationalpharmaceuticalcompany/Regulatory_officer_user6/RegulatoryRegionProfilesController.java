package org.example.multinationalpharmaceuticalcompany.Regulatory_officer_user6;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.multinationalpharmaceuticalcompany.Regulatory_officer_user6.ModelClass.RegionProfile;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class RegulatoryRegionProfilesController
{
    @javafx.fxml.FXML
    private DatePicker date;
    @javafx.fxml.FXML
    private ComboBox<String > nameCB;
    @javafx.fxml.FXML
    private TableColumn<RegionProfile, String> levelCl;
    @javafx.fxml.FXML
    private TableColumn<RegionProfile, String> dateCl;
    @javafx.fxml.FXML
    private TableView<RegionProfile> tableView;
    @javafx.fxml.FXML
    private TextArea rules;
    @javafx.fxml.FXML
    private ComboBox<String> levelCB;
    @javafx.fxml.FXML
    private TableColumn<RegionProfile, String> nameCl;
    @javafx.fxml.FXML
    private TableColumn<RegionProfile, String> rulesCl;

    private ArrayList<RegionProfile> regionProfiles = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        nameCB.getItems().addAll("Dhaka", "Chittagong", "Khulna", "Barisal", "Sylhet", "Rajshahi", "Rangpur", "Mymensingh");
        levelCB.getItems().addAll("Low", "Medium", "High");

        nameCl.setCellValueFactory(new PropertyValueFactory<>("regionName"));
        levelCl.setCellValueFactory(new PropertyValueFactory<>("authorityLevel"));
        dateCl.setCellValueFactory(new PropertyValueFactory<>("date"));
        rulesCl.setCellValueFactory(new PropertyValueFactory<>("rules"));
    }

    @javafx.fxml.FXML
    public void loadButton(ActionEvent actionEvent) {
        try (ObjectInputStream input = new ObjectInputStream( new FileInputStream("region.bin"))) {
            tableView.getItems().clear();
            int size = input.readInt();
            for (int i = 0; i < size; i++) {
                RegionProfile regionProfile = (RegionProfile) input.readObject();
                tableView.getItems().add(regionProfile);
            }
        } catch (IOException e) {
            System.out.println("Error reading file");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void saveButton(ActionEvent actionEvent) {
        if (nameCB.getValue() == null || levelCB.getValue() == null || date.getValue() == null || rules.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all fields.");
            alert.showAndWait();
            return;
        }

        LocalDate local = date.getValue();
        if (local.isBefore(LocalDate.now()) || local.isEqual(LocalDate.now())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText(null);
            alert.setContentText("Date cannot be in the past.");
            alert.showAndWait();
            return;
        }

        RegionProfile regionProfile = new RegionProfile(
                nameCB.getValue(),
                levelCB.getValue(),
                rules.getText(),
                date.getValue().toString()
        );
        regionProfiles.add(regionProfile);

        try (ObjectOutputStream output = new ObjectOutputStream( new FileOutputStream("region.bin"))) {
            output.writeInt(regionProfiles.size());
            for (RegionProfile e : regionProfiles) {
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

        nameCB.setValue(null);
        levelCB.setValue(null);
        date.setValue(null);
        rules.clear();
    }
}