package com.example.banco_central_nlogonia;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
public class InicioApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

            FXMLLoader fxmlLoader = new FXMLLoader(AgregarTarjetaApplication.class.getResource("Inicio-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 448, 542);
            stage.setTitle("   Inicio  ");
            stage.setScene(scene);
            stage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}
