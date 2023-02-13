package com.example.practica3modulosfx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    @FXML
    private TextField campoNombre;

    @FXML
    private TextField campoApellidos;

    @FXML
    private TextField campoNif;

    @FXML
    private TextField campoCodigoPostal;

    @FXML
    private TextField campoCorreoElectronico;

    @FXML
    private Button botonMostrar;


    @FXML
    protected void onMostrarButtonClick() {
        /*
        System.out.println("Nombre: "+campoNombre.getText());
        System.out.println("Apellidos: "+campoApellidos.getText());
        System.out.println("NIF: "+campoNif.getText());
        System.out.println("Código Postal: "+campoCodigoPostal.getText());
        System.out.println("Correo electrónico: "+campoCorreoElectronico.getText());
        */

        Node source = (Node) botonMostrar;     //Me devuelve el elemento al que hice click
        Stage stage = (Stage) source.getScene().getWindow();
        System.out.println(stage);
        //etiquetaNombreYApellidos.setText(HelloController.campoNombre.getText()+" "+campoApellidos.getText());
    }

    public TextField getCampoNombre() {
        return campoNombre;
    }

    public TextField getCampoApellidos() {
        return campoApellidos;
    }

    public TextField getCampoNif() {
        return campoNif;
    }

    public TextField getCampoCodigoPostal() {
        return campoCodigoPostal;
    }

    public TextField getCampoCorreoElectronico() {
        return campoCorreoElectronico;
    }

    @FXML
    protected void onbotonEmergenteClick() throws Exception {


        try {

            // Cargo la vista
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("ventanaEmergente.fxml"));

            // Cargo la ventana
            Parent root = loader.load();

            // Creo el Scene
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Datos de la matrícula");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText(e.getMessage());
            System.out.println(e.getMessage().toString());
            alert.showAndWait();
        }
    }


    @FXML
    protected void onMostrarDatosButtonClick() {
        Node source = (Node) botonMostrar;     //Me devuelve el elemento al que hice click
        Stage stage = (Stage) source.getScene();
        System.out.println(stage);
        //etiquetaNombreYApellidos.setText(HelloController.campoNombre.getText()+" "+campoApellidos.getText());
    }
}