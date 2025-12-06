module org.example.multinationalpharmaceuticalcompany {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens org.example.multinationalpharmaceuticalcompany.Administrator to javafx.fxml;
    opens org.example.multinationalpharmaceuticalcompany.Administrator.ModelClass to javafx.base;
    opens org.example.multinationalpharmaceuticalcompany.ResearchScientist to javafx.fxml;
    opens org.example.multinationalpharmaceuticalcompany.ResearchScientist.ModelClass to javafx.base;


    opens org.example.multinationalpharmaceuticalcompany to javafx.fxml;
    exports org.example.multinationalpharmaceuticalcompany;
}
