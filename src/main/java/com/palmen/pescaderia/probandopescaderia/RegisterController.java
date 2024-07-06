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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    @FXML
    private Label lblErrorCorreo;

    @FXML
    private Label lblErrorUsuario;

    @FXML
    private Label lblErrorContraseña;

    @FXML
    private Label lblRegistroExitoso;

    @FXML
    private Label lblRegistroFallido;

    public void registerUsuario() {
        btnRegistrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String correo = txtCorreoRegistro.getText();
                String usuario = txtUsuarioRegistro.getText();
                String clave = txtContraseñaRegistro.getText();

                verificarCampos(correo, usuario, clave);
            }
        });
    }

    public void verificarCampos(String correo, String usuario, String clave) {
        Pattern pattern = Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");

        Matcher matcher = pattern.matcher(correo);

        if (correo.isEmpty()) {
            lblErrorCorreo.setText("El campo no puede estar vacío");
        } else if (!matcher.matches()) {
            lblErrorCorreo.setText("El email debe tener un formato válido");
        } else {
            lblErrorCorreo.setText("");
        }

        if (usuario.isEmpty()) {
            lblErrorUsuario.setText("El campo no puede estar vacío");
        } else {
            lblErrorUsuario.setText("");
        }

        if (clave.isEmpty()) {
            lblErrorContraseña.setText("El campo no puede estar vacío");
        } else {
            lblErrorContraseña.setText("");
        }

        if (lblErrorCorreo.getText().isEmpty() && lblErrorUsuario.getText().isEmpty() && lblErrorContraseña.getText().isEmpty()) {
            if (!UsuarioDAO.existeUsuario(correo)) {
                UsuarioDAO.crearUsuario(correo, usuario, clave);
                lblRegistroExitoso.setText("El registro ha sido exitoso");
                lblRegistroFallido.setText("");
            } else {
                lblRegistroExitoso.setText("");
                lblRegistroFallido.setText("El email ya está en uso");
            }
        }
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

