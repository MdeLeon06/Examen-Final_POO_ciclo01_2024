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

public class ContrasenaAdministradorController { //00160223 Inicio de la logica de la interfaz del ContrasenaAdministrador

    @FXML
    private Label lblVerificarAdmin; //00160223 Declarando Label de "Verificacion de Administrador".

    @FXML
    private Label lblContrasenaAdmin; //00160223 Declarando Label de "Contraseña de admin".

    @FXML
    private TextField txtFContrasenaAdmin; //00160223 Declarando TextField de "Contraseña Administrador".

    @FXML
    private Button btnEntrar; //00160223 Declarando Button para entrar a los reportes del Administrador

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
    void Contrasena(ActionEvent event) { //00160223 Metodo que se ejecuta cuando el usuario le da al botón de Entrar
        String contrasena = "1234"; //00160223 Estableciendo contraseña para que el Administrador pueda entrar
        String password = txtFContrasenaAdmin.getText(); //00160223 Obteniendo el dato establecido para ver si puede entrar la persona
        if (password == contrasena) { //00160223 Condicion if, que verifica que la contraseña establecida sea igual a la contraseña digitada por el usuario
            System.out.println("Acceso concedido"); //00160223 Si la condicion se cumple, se da un mensaje de que la contraseña es correcta
            changeScene(event, "PantallaAdministrador-view.fxml"); //00160223 Estableciendo el nombre del archivo fxml con el que queremos el cambio de escena
        } else { //00160223 Si la condicion no se cumple, pasa a lo siguiente:
            System.out.println("Contraseña incorrecta"); //00160223 Si la condicion no se cumple, se da un mensaje de que la contraseña es incorrecta.
        }
    }
}
