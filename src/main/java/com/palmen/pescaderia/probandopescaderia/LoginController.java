package com.palmen.pescaderia.probandopescaderia;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private Button btnConectar;

    @FXML
    private ImageView imLogo;

    @FXML
    private ImageView imgFondo;

    @FXML
    private Label lblContraseña;

    @FXML
    private Label lblLogin;

    @FXML
    private Label lblUsuario;

    @FXML
    private Pane mainPane;

    @FXML
    private PasswordField txtContraseña;

    @FXML
    private TextField txtUsuario;


    public void loginUsuario() {
        btnConectar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Agrega aquí el código que deseas ejecutar al hacer clic en el botón
                if (txtUsuario.getText().equals("root") && txtContraseña.getText().equals("admin")) {
                    System.out.println("El usuario y la contraseña son correctos");
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("StockPescaderia.fxml"));
                        Scene scene = new Scene(loader.load(), 950, 600);

                        Stage stageOld = (Stage) btnConectar.getScene().getWindow();
                        stageOld.close();

                        Stage stage = new Stage();
                        stage.setTitle("Administador Stock Pescaderia");
                        stage.setResizable(false);
                        stage.setScene(scene);
                        stage.show();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                } else {
                    System.out.println("Los datos no son correctos");
                }
            }
        });
    }

    @FXML
    private void initialize() {
        loginUsuario();
    }

}
