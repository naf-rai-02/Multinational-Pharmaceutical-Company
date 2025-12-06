module org.example.multinationalpharmaceuticalcompany {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;

    opens org.example.multinationalpharmaceuticalcompany.Production_Manager to javafx.fxml;
    opens org.example.multinationalpharmaceuticalcompany.Production_Manager.ModelClass to javafx.base;
    opens org.example.multinationalpharmaceuticalcompany.Quality_Assurance_Officer to javafx.fxml;
    opens org.example.multinationalpharmaceuticalcompany.Quality_Assurance_Officer.ModelClass to javafx.base;

    opens org.example.multinationalpharmaceuticalcompany to javafx.fxml;
    exports org.example.multinationalpharmaceuticalcompany;
}
