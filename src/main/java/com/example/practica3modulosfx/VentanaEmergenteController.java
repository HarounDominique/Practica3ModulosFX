package com.example.practica3modulosfx;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class VentanaEmergenteController {

    @FXML
    private Label etiquetaNombreYApellidos;

    @FXML
    private Label etiquetaNif;

    @FXML
    private Label etiquetaCorreoElectronico;

    @FXML
    private Button botonCerrar;

    @FXML
    private Button botonMostrarDatos;

    public Label getEtiquetaNombreYApellidos() {
        return etiquetaNombreYApellidos;
    }

    public void setEtiquetaNombreYApellidos(Label etiquetaNombreYApellidos) {
        this.etiquetaNombreYApellidos = etiquetaNombreYApellidos;
    }


}
