module com.example.renteserver {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.renteserver to javafx.fxml;
    exports com.example.renteserver;
}