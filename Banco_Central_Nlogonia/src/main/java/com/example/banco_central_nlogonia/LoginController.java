package com.example.banco_central_nlogonia;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController { //00160223 Inicio de la logica de la interfaz del Login

    @FXML
    private Label lblBienvenida; //00160223 Declarando Label de "Bienvenida".

    @FXML
    private Label lblUsuario; //00160223 Declarando Label de "Usuario".

    @FXML
    private Label lblInformacionUsuario; //00160223 Declarando Label de "Informacion para el Usuario".

    @FXML
    private Label lblInfomacionAdministrador; //00160223 Declarando Label de "Informacion para el administrador".

    @FXML
    private TextField txtFUsuario; //00160223 Declarando el TextField del Label "Usuario"

    @FXML
    private Label lblContrasena; //00160223 Declarando el Label de "Contraseña"

    @FXML
    private TextField txtFContrasena; //00160223 Declarando el TextField del Label "Contraseña"

    @FXML
    private Button btnIngresar; //00160223 Declarando el Button para Ingresar y seguir a la siguiente pantalla

    @FXML
    private Label lblCrearUsuario; //00160223 Declarando el Label de "Crear Usuario"

    @FXML
    private Button btbNuevoUsuario; //00160223 Declarando el Button de Nuevo Usuario

    @FXML
    private Label lblError; //00160223 Declarando el Label de Error por si el usuario no completa los datos solicitados

    @FXML
    private Button btnAdministrador; //00160223 Declarando el Button de Administrador

    @FXML
    private Line lineLineaDivisora; //00160223 Declarando una Line para dividir el inicio de sesion del usuario ya registrado y del nuevo usuario



    @FXML
    public void initialize() { //00160223 Inizializando la Interfaz
        lblError.setText(""); //00160223 Limpia el area del texto del Label error.
    }

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
    private void IngresarDatosLogin(ActionEvent event) { //00160223 Metodo que se ejecuta cuando el usuario le da al botón de Ingresar

        String usuario = txtFUsuario.getText(); //00160223 Obteniendo el dato establecido para el usuario registrado
        String contrasena = txtFContrasena.getText(); //00160223 Obteniendo la contraseña establecida del usuario registrado

        if (usuario.isEmpty() || contrasena.isEmpty()) { //00160223 Condicion if, que verifica si el textField del usuario o contraseña estan vacios
            lblError.setText("Por favor ingrese un usuario y contraseña."); //00160223 Si la condicion se cumple, enseña un texto en el Label de Error.
        } else { //00160223 Si la condicion no se cumple, pasa a lo siguiente:
            lblError.setText(""); //00160223 Muestra el Label de Error vacio
            System.out.println("Iniciando sesion con el usuario: " + usuario); //00160223 Mostrando mensaje de Iniciando Sesion con el usuario ingresado
            changeScene(event, "Transaccion-view.fxml"); //00160223 Estableciendo el nombre del archivo fxml con el que queremos el cambio de escena
        }
    }

    @FXML
    private void IngresoNuevoUsuario(ActionEvent event) { //00160223 Metodo que esta establecido en el botón de "Nuevo Usuario"
        changeScene(event, "NuevoUsuario-view.fxml"); //00160223 Estableciendo el nombre del archivo fxml con el que queremos el cambio de escena
    }

}