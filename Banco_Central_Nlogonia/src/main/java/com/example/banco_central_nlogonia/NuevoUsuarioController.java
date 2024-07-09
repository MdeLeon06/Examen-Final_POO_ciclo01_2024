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

public class NuevoUsuarioController {
    @FXML
    private Label lblCreacionUsuario;

    @FXML
    private Label lblNombreCompleto;

    @FXML
    private Label lblTelefono;

    @FXML
    private Label lblDireccion;

    @FXML
    private Label lblUsuarioN;

    @FXML
    private Label lblContrasenaN;

    @FXML
    private Button btnAgregarUsuario;

    @FXML
    private Button btnSiguiente;

    @FXML
    private TextField txtFNombreCompleto;

    @FXML
    private TextField txtFTelefono;

    @FXML
    private TextField txtFDireccion;

    @FXML
    private TextField txtFUsuarioN;

    @FXML
    private TextField txtFContrasenaN;

    @FXML
    private Label lblError;


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
    private void DatosNuevos(ActionEvent event) {

        String usuario = txtFNombreCompleto.getText();
        String telefono = txtFTelefono.getText();
        String direccion = txtFDireccion.getText();
        String usuarioN = txtFUsuarioN.getText();
        String contrasenaN = txtFContrasenaN.getText();

        if (usuario.isEmpty() || telefono.isEmpty() || direccion.isEmpty() || usuarioN.isEmpty() || contrasenaN.isEmpty()) {
            lblError.setText("Por favor revise que todos los datos esten llenados completamente.");
        } else {
            lblError.setText("");
            System.out.println("Agregando los datos");
        }
    }

    @FXML
    private void PantallaTarjeta(ActionEvent event) {
        changeScene(event, "AgregarTarjeta-view.fxml");
    }

}
