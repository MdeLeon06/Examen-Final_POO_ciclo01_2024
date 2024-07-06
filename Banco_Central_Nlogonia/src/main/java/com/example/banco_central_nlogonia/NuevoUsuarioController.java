package com.example.banco_central_nlogonia;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class NuevoUsuarioController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
