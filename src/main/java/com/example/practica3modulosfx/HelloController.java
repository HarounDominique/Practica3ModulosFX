package com.example.practica3modulosfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloController {
    @FXML
    private SplitPane raiz;

    @FXML
    private GridPane panelDatos;
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

    //creo el objeto alumno que almacenará los datos cuando se pulse el botón gardar(o como se llame)
    private Alumno alumno;

    //creo el array de módulos que necesito para instanciar alumnos en el método
    public ArrayList<Modulo> modulos;

    //método que guarda en variables los datos de los campos de la vista e instancia un objeto alumno con esos datos

    //Método que se dispara al guardar los datos de los alumnos
    @FXML
    protected void onGuardar(ActionEvent event) throws Exception {
        if (comprobarCamposVacios()) {
            limpiarCamposTexto();
            //pendiente de crear un método que muestre una alerta en la consola
            //mostrarAlertError("Existen cuadros de texto vacios");
        }

        else {
            guardar();

            //Al pulsar el botón guardar desactivo Cancelar
            cancelar.setDisable(true);
            try {

                // Cargo la vista
                FXMLLoader loader = new FXMLLoader(CiclosApplication.class.getResource("VentanaMostrar.fxml"));
                // Cargo la ventana
                Parent root = loader.load();
                Stage stage = new Stage();
                // Estamos pasando el alumno a la instancia del stage
                stage.setUserData(alumno);
                // Creo el Scene
                Scene scene = new Scene(root);
                stage.setTitle("Datos matricula alumnado!");
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
    }

    @FXML
    private void guardar() {
        String nombre = campoNombre.getText().trim();
        String apellido = campoApellidos.getText().trim();
        String nif = campoNif.getText().trim();
        String codigopostal = campoCodigoPostal.getText().trim();
        String correoelectronico = campoCorreoElectronico.getText().trim();

        alumno = new Alumno(nombre, apellido, correoelectronico, codigopostal, nif, modulos);
    }


    //método que comprueba si hay valores vacíos en los campos de texto de la vista
    @FXML
    private boolean comprobarCamposVacios() {
        Boolean algunCampoVacio = false;

        for (int i = 0; i < panelDatos.getChildren().size(); i++) {
            Node nodo = panelDatos.getChildren().get(i);
            //comprobamos que el nodo sea un textField
            if (nodo instanceof TextField) {
                //creamos un objeto textField partiendo de nodo, casteándolo
                TextField texto = (TextField) nodo;
                //y comprobamos que el contenido del texto no esté vacío
                if (texto.getLength() == 0) {
                    //si está vacío, ponemos el boolean a true y salimos del bucle con un break
                    algunCampoVacio = true;
                    break;
                }
            }
        }
        return algunCampoVacio;
    }
    //método que limpia los campos de texto de la vista
    @FXML
    private void limpiarCamposTexto() {
        //Comprobamos cada uno de los elmentos hijos y para cada uno de ellos los ponemos en blanco
        panelDatos.getChildren().forEach((Node node) -> {
            if (node instanceof TextField)
                ((TextField) node).clear();
        });
        //Ponemos el focus en el campo nombre
        campoNombre.requestFocus();
    }

    @FXML
    private void onMostrarButtonClick() {
        /*
        System.out.println("Nombre: "+campoNombre.getText());
        System.out.println("Apellidos: "+campoApellidos.getText());
        System.out.println("NIF: "+campoNif.getText());
        System.out.println("Código Postal: "+campoCodigoPostal.getText());
        System.out.println("Correo electrónico: "+campoCorreoElectronico.getText());
        */

        // Cargamos la vista, le añado el documento fxml correspondiente
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("VentanaEmergente.fxml"));
        Parent root;
        // Cargamos la ventana
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();

        stage.setUserData(alumno);
        // Creo el Scene
        Scene scene = new Scene(root);
        stage.setTitle("Datos matricula alumnado!");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
        /*
        Node source = (Node) botonMostrar;     //Me devuelve el elemento al que hice click
        Stage stage = (Stage) source.getScene().getWindow();
        System.out.println(stage);
         */
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

    //Esta función la he copiado de Ventana, es sólo de prueba y no he logrado nada
    @FXML
    protected void onMostrarDatosButtonClick() {
        Node source = (Node) botonMostrar;     //Me devuelve el elemento al que hice click
        Stage stage = (Stage) source.getScene().getWindow();
        System.out.println(stage);
        //etiquetaNombreYApellidos.setText(HelloController.campoNombre.getText()+" "+campoApellidos.getText());
    }
}