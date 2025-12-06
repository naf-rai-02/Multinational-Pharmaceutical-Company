package org.example.multinationalpharmaceuticalcompany.Production_Manager;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import org.example.multinationalpharmaceuticalcompany.Production_Manager.ModelClass.CreateBatch;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class CreateDigitalProductionBatchesController
{
    @javafx.fxml.FXML
    private DatePicker date;
    @javafx.fxml.FXML
    private TextField quantity;
    @javafx.fxml.FXML
    private ComboBox<String> priorityCB;
    @javafx.fxml.FXML
    private TextArea details;
    @javafx.fxml.FXML
    private TextField batchID;
    @javafx.fxml.FXML
    private TextField productName;

    private ArrayList<CreateBatch> batches = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        priorityCB.getItems().addAll("Low", "Medium", "High");
    }

    @javafx.fxml.FXML
    public void createButton(ActionEvent actionEvent) {
        if (batchID.getText().isEmpty() || productName.getText().isEmpty() || quantity.getText().isEmpty() || date.getValue() == null || priorityCB.getValue() == null || details.getText().isEmpty()) {
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

        for (CreateBatch e : batches) {
            if (e.getBatchID().equals(batchID.getText())) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("Batch ID Already Exists");
                alert.setContentText("Please enter a different Batch ID");
                alert.showAndWait();
                return;
            }
        }

        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("batchcreate.bin"))) {
            int size = input.readInt(); // read how many objects are stored
            for (int i = 0; i < size; i++) {
                CreateBatch batch = (CreateBatch) input.readObject();
                for (CreateBatch e : batches) {
                    if (e.getBatchID().equals(batch.getBatchID())) {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Warning");
                        alert.setHeaderText("Batch ID Already Exists");
                        alert.setContentText("Please enter a different Batch ID");
                        alert.showAndWait();
                        return;
                    }
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        String status = "Pending";
        CreateBatch createBatch = new CreateBatch(batchID.getText(), productName.getText(), quantity.getText(), priorityCB.getValue(), details.getText(), date.getValue().toString(), status);
        batches.add(createBatch);

        try (ObjectOutputStream output = new ObjectOutputStream( new FileOutputStream("batchcreate.bin"))) {
            output.writeInt(batches.size());
            for (CreateBatch e : batches) {
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

        batchID.clear();
        productName.clear();
        quantity.clear();
        date.setValue(null);
        priorityCB.setValue(null);
        details.clear();
    }
}