package com.palmen.pescaderia.probandopescaderia.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

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
