package com.palmen.pescaderia.probandopescaderia.controllers;

import com.palmen.pescaderia.probandopescaderia.models.UsuarioDAO;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class RegisterController {

    @FXML
    private Button btnRegistrar;

    @FXML
    private ImageView imLogo;

    @FXML
    private ImageView imgFondo;

    @FXML
    private Label lblContraseñaRegistro;

    @FXML
    private Label lblCorreoRegistro;

    @FXML
    private Label lblHaciaLogin;

    @FXML
    private Label lblRegistro;

    @FXML
    private Label lblUsuarioRegistro;

    @FXML
    private Pane registroPane;

    @FXML
    private PasswordField txtContraseñaRegistro;

    @FXML
    private TextField txtCorreoRegistro;

    @FXML
    private TextField txtUsuarioRegistro;

    public void registerUsuario() {
        btnRegistrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String correo = txtCorreoRegistro.getText();
                String usuario = txtUsuarioRegistro.getText();
                String clave = txtContraseñaRegistro.getText();

                UsuarioDAO.crearUsuario(correo, usuario, clave);
            }
        });
    }

    @FXML
    private void initialize() {
        registerUsuario();
    }
}

