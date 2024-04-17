package com.palmen.pescaderia.probandopescaderia;

import com.palmen.pescaderia.probandopescaderia.models.UsuarioDAO;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

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

    public void lblHaciaLoginAction() {
        lblHaciaLogin.setOnMouseClicked(e -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("LoguinPescaderia.fxml"));
                Scene scene = new Scene(loader.load());

                Stage stageOld = (Stage) lblHaciaLogin.getScene().getWindow();
                stageOld.close();

                Stage stage = new Stage();
                stage.setTitle("Administador Stock Pescaderia");
                stage.setResizable(false);
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        lblHaciaLogin.setOnMouseEntered(e -> {
            lblHaciaLogin.setCursor(Cursor.HAND);
        });

        lblHaciaLogin.setOnMouseExited(e -> {
            lblHaciaLogin.setCursor(Cursor.DEFAULT);
        });
    }

    @FXML
    private void initialize() {
        registerUsuario();
        lblHaciaLoginAction();
    }
}

