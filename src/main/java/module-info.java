module com.example.lightcityfloat {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
    opens com.example.lightcityfloat to javafx.fxml;
    exports com.example.lightcityfloat;
    exports com.example.lightcityfloat.ControllerClasses;
    opens com.example.lightcityfloat.ControllerClasses to javafx.fxml;
}