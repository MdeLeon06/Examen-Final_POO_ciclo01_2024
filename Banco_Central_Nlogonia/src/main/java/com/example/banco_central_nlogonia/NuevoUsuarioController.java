package com.example.banco_central_nlogonia;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class NuevoUsuarioController { //00160223 Inicio de la logica de la interfaz del NuevoUsuario
    @FXML
    private Label lblCreacionUsuario; //00160223 Declarando Label de "Creacion Usuario".

    @FXML
    private Label lblNombreCompleto; //00160223 Declarando Label de "Nombre Completo".

    @FXML
    private Label lblTelefono; //00160223 Declarando Label de "telefono".

    @FXML
    private Label lblDireccion; //00160223 Declarando Label de "Direccion".

    @FXML
    private Label lblUsuarioN; //00160223 Declarando Label de "Usuario".

    @FXML
    private Label lblContrasenaN; //00160223 Declarando Label de "Contraseña".

    @FXML
    private Button btnAgregarUsuario; //00160223 Declarando el Button para agregar los datos del nuevo usuario

    @FXML
    private Button btnSiguiente; //00160223 Declarando el Button para seguir a la siguiente pantalla

    @FXML
    private TextField txtFNombreCompleto; //00160223 Declarando el TextField del Label "Nombre Completo"

    @FXML
    private TextField txtFTelefono; //00160223 Declarando el TextField del Label "Telefono"

    @FXML
    private TextField txtFDireccion; //00160223 Declarando el TextField del Label "Direccion"

    @FXML
    private TextField txtFUsuarioN; //00160223 Declarando el TextField del Label "Usuario"

    @FXML
    private TextField txtFContrasenaN; //00160223 Declarando el TextField del Label "Contraseña"

    @FXML
    private Label lblError; //00160223 Declarando Label de Error, por si el usuario no ingresa los datos solicitados.


    @FXML
    private void changeScene(ActionEvent event, String File) { //00160223 Metodo para poder cambiar de pantalla en los diferentes metodos donde se necesite este metodo.
        try { //00160223 Encapsulamiento del codigo a ejecutar, por si ocurre una excepcion.
            FXMLLoader loader = new FXMLLoader(getClass().getResource(File)); //00160223 Aqui se Carga el archivo fxml
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //00160223 Obtiene el escenario, la ventana actual
            Scene scene = new Scene(loader.load()); //00160223 Se carga la nueva escena a la que se cambio
            stage.setScene(scene); //00160223 Configuracion del Stage con la nueva pantalla
            stage.show(); //00160223 Muestra la nueva pantalla
        } catch (IOException e) { //00160223 Captura la excepcion y tira un IOException
            e.printStackTrace(); //00160223 Proporciona los datos de la excepcion
        }
    }

    @FXML
    private void DatosNuevos(ActionEvent event) { //00160223 Metodo que se ejecuta cuando se da al botón de Agregar

        String nombreUsuario = txtFNombreCompleto.getText(); //00160223 Obteniendo el dato establecido para el nombre del usuario nuevo
        String telefono = txtFTelefono.getText(); //00160223 Obteniendo el dato establecido para el telefono del usuario nuevo
        String direccion = txtFDireccion.getText(); //00160223 Obteniendo el dato establecido para la direccion del usuario nuevo
        String usuarioN = txtFUsuarioN.getText(); //00160223 Obteniendo el dato establecido para el usuario del usuario nuevo
        String contrasenaN = txtFContrasenaN.getText(); //00160223 Obteniendo el dato establecido para la contraseña del usuario nuevo

        if (nombreUsuario.isEmpty() || telefono.isEmpty() || direccion.isEmpty() || usuarioN.isEmpty() || contrasenaN.isEmpty()) { //00160223 Condicion if, que verifica si el textField del nombre del usuario, telefono, direccion, usuario o contraseña estan vacios
            lblError.setText("Por favor revise que todos los datos esten llenados completamente."); //00160223 Si la condicion se cumple, enseña un texto en el Label de Error.
        } else { //00160223 Si la condicion no se cumple, pasa a lo siguiente:
            lblError.setText(""); //00160223 Muestra el Label de Error vacio
            System.out.println("Agregando los datos"); //00160223 Mostrando mensaje de Agregando los Datos del usuaario nuevo
        }
    }

    @FXML
    private void PantallaTarjeta(ActionEvent event) { //00160223 Metodo que esta establecido en el botón de "Siguiente"
        changeScene(event, "AgregarTarjeta-view.fxml"); //00160223 Estableciendo el nombre del archivo fxml con el que queremos el cambio de escena
    }

}
