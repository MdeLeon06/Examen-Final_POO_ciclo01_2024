package com.example.banco_central_nlogonia; // 00126123 Define el paquete para la clase

import javafx.fxml.FXML; // 00126123 Importa la anotación FXML de JavaFX
import javafx.scene.control.Label; // 00126123 Importa la clase Label de JavaFX

public class TotalMesController { // 00126123 Define la clase controladora

    @FXML // 00126123 Anotación para inyectar el componente FXML
    private Label welcomeText; // 00126123 Define la etiqueta welcomeText

    @FXML // 00126123 Anotación para el método manejador de eventos
    protected void onHelloButtonClick() { // 00126123 Método manejador del clic en el botón
        welcomeText.setText("Welcome to JavaFX Application!"); // 00126123 Cambia el texto de la etiqueta al hacer clic en el botón
    }
}
