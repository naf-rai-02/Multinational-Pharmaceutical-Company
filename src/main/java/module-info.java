module org.example.multinationalpharmaceuticalcompany {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.multinationalpharmaceuticalcompany to javafx.fxml;
    exports org.example.multinationalpharmaceuticalcompany;
}