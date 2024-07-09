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

public class LoginController {

    @FXML
    private Label lblBienvenida;

    @FXML
    private Label lblUsuario;

    @FXML
    private TextField txtFUsuario;

    @FXML
    private Label lblContrasena;

    @FXML
    private TextField txtFContrasena;

    @FXML
    private Button btnIngresar;

    @FXML
    private Label lblCrearUsuario;

    @FXML
    private Button btbNuevoUsuario;

    @FXML
    private Label lblError;


    /*
    @FXML
    public void initialize() {
        lblError.setText("");
    }*/

    @FXML
    private void changeScene(ActionEvent event, String File) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource(File));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(loader.load());
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    @FXML
    private void IngresarDatosLogin(ActionEvent event) {

        String usuario = txtFUsuario.getText();
        String contrasena = txtFContrasena.getText();

        if (usuario.isEmpty() || contrasena.isEmpty()) {
            lblError.setText("Por favor ingrese un usuario y contraseña.");
        } else {
            lblError.setText("");
            System.out.println("Iniciando sesion con el usuario: " + usuario);
            changeScene(event, "Transaccion-view.fxml");
        }
    }

    @FXML
    private void IngresoNuevoUsuario(ActionEvent event) {
        changeScene(event, "NuevoUsuario-view.fxml");
    }

}