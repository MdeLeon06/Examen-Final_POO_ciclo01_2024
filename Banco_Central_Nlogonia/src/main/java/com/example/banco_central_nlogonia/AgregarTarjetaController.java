package com.example.banco_central_nlogonia;

import javafx.event.ActionEvent; //00063923 Importa las clases necesarias para manejar eventos de acción en JavaFX.
import javafx.fxml.FXML; //00063923 Importa las clases necesarias para trabajar con FXML.
import javafx.fxml.FXMLLoader; //00063923 Importa las clases necesarias para cargar archivos FXML.
import javafx.scene.Node; //00063923 Importa las clases necesarias para trabajar con nodos en la escena.
import javafx.scene.Parent; //00063923 Importa las clases necesarias para trabajar con el nodo raíz de la escena.
import javafx.scene.Scene; //00063923 Importa las clases necesarias para trabajar con escenas en JavaFX.
import javafx.stage.Stage; //00063923 Importa las clases necesarias para trabajar con ventanas (escenarios) en JavaFX.

import java.io.IOException; //00063923 Importa la clase necesaria para manejar excepciones de entrada/salida.

public class AgregarTarjetaController { //00063923 Define la clase del controlador para la pantalla de agregar tarjeta.

    @FXML //00063923 Indica que el siguiente método es un controlador de eventos FXML.
    private void volverAInicio(ActionEvent event) throws IOException { //00063923 Método que se ejecuta cuando se desea volver a la pantalla de inicio.
        cargarPantalla(event, "/com/example/banco_central_nlogonia/Inicio-view.fxml"); //00063923 Llama al método cargarPantalla con la ruta del archivo FXML correspondiente a la pantalla de inicio.
    }

    private void cargarPantalla(ActionEvent event, String fxmlPath) throws IOException { //00063923 Método que realiza la carga de la nueva pantalla.
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath)); //00063923 Crea un nuevo FXMLLoader y le da la ruta del archivo FXML a cargar.
        Parent root = loader.load(); //00063923 Carga el archivo FXML y obtiene el nodo raíz.

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //00063923 Obtiene el escenario actual a partir del nodo que disparó el evento.
        stage.setScene(new Scene(root)); //00063923 Establece la nueva escena en el escenario.
        stage.show(); //00063923 Muestra la nueva escena.
    }
}

