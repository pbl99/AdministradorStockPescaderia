module com.palmen.pescaderia.probandopescaderia {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.palmen.pescaderia.probandopescaderia to javafx.fxml;
    exports com.palmen.pescaderia.probandopescaderia;
    exports com.palmen.pescaderia.probandopescaderia.controllers;
    opens com.palmen.pescaderia.probandopescaderia.controllers to javafx.fxml;
}