package com.example.banco_central_nlogonia;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class RangoFechasApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(NuevoUsuarioApplication.class.getResource("RangoFechas-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 650);
        stage.setTitle("   Búsqueda de compras realizadas  ");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
