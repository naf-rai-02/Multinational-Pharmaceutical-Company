module org.example.multinationalpharmaceuticalcompany {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens org.example.multinationalpharmaceuticalcompany.Regulatory_officer_user6 to javafx.fxml;
    opens org.example.multinationalpharmaceuticalcompany.Regulatory_officer_user6.ModelClass to javafx.base;
    opens org.example.multinationalpharmaceuticalcompany.Sales_marketing_user5 to javafx.fxml;
    opens org.example.multinationalpharmaceuticalcompany.Sales_marketing_user5.ModelClass to javafx.base;

    opens org.example.multinationalpharmaceuticalcompany to javafx.fxml;
    exports org.example.multinationalpharmaceuticalcompany;
}
