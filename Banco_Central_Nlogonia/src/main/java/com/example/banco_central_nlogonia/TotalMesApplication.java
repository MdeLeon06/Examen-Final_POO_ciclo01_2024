package com.example.banco_central_nlogonia; // 00126123 Paquete en el que se encuentra la clase

import javafx.application.Application; // 00126123 Importa la clase Application de JavaFX
import javafx.fxml.FXMLLoader; // 00126123 Importa la clase FXMLLoader
import javafx.scene.Scene; // 00126123 Importa la clase Scene de JavaFX
import javafx.stage.Stage; // 00126123 Importa la clase Stage de JavaFX

import java.io.IOException; // 00126123 Importa la clase IOException

public class TotalMesApplication extends Application { // 00126123 Define la clase principal que extiende Application
    @Override
    public void start(Stage stage) throws IOException { // 00126123 Sobrescribe el método start, punto de entrada de la aplicación JavaFX
        FXMLLoader fxmlLoader = new FXMLLoader(NuevoUsuarioApplication.class.getResource("TotalMes-view.fxml")); // 00126123 Carga el archivo FXML e indica a que pantalla esta conectado
        Scene scene = new Scene(fxmlLoader.load(), 500, 600); // 00126123 Crea una nueva escena con el contenido cargado y establece su tamaño
        stage.setTitle("   Compras realizadas según facilitador  "); // 00126123 Establece el título de la pantalla
        stage.setScene(scene); // 00126123 Establece el escenario
        stage.show(); //00126123  Muestra el escenario
    }

    public static void main(String[] args) { // 00126123 Método main para iniciar la aplicación
        launch(); // 00126123 Llama al método launch para iniciar la aplicación JavaFX
    }
}

