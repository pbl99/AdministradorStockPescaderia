package com.palmen.pescaderia.probandopescaderia;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("StockPescaderia.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 747, 365);
        Scene scene = new Scene(fxmlLoader.load(), 950, 600);
        // Este scene para aproximar tamaño de la vista StockPescaderia

        stage.setTitle("Administador Stock Pescaderia");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}