module org.example.multinationalpharmaceuticalcompany {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;

    opens org.example.multinationalpharmaceuticalcompany to javafx.fxml;
    exports org.example.multinationalpharmaceuticalcompany;

    opens org.example.multinationalpharmaceuticalcompany.sales_marketing_user5 to javafx.fxml;
    exports org.example.multinationalpharmaceuticalcompany.sales_marketing_user5;

    opens org.example.multinationalpharmaceuticalcompany.administrator_user1 to javafx.fxml;
    exports org.example.multinationalpharmaceuticalcompany.administrator_user1;

    opens org.example.multinationalpharmaceuticalcompany.production_manager_user3 to javafx.fxml;
    exports org.example.multinationalpharmaceuticalcompany.production_manager_user3;
}
