module com.example.practica3modulosfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.practica3modulosfx to javafx.fxml;
    exports com.example.practica3modulosfx;
}