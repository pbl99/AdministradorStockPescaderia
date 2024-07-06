package com.palmen.pescaderia.probandopescaderia;

import com.palmen.pescaderia.probandopescaderia.models.StockDAO;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class StockController {

    @FXML
    private Button btnUsuario;

    @FXML
    private ImageView imgBacalao;

    @FXML
    private ImageView imgBoqueron;

    @FXML
    private ImageView imgDorada;

    @FXML
    private ImageView imgGamba;

    @FXML
    private ImageView imgLenguado;

    @FXML
    private ImageView imgLubina;

    @FXML
    private ImageView imgMerluza;

    @FXML
    private ImageView imgPulpo;

    @FXML
    private ImageView imgSalmon;

    @FXML
    private ImageView imgSardina;

    @FXML
    private ImageView imgSepia;

    @FXML
    private ImageView imgTrucha;

    @FXML
    private ImageView imgUsuarioLogo;

    @FXML
    private Label lblBacalao;

    @FXML
    private Label lblBoqueron;

    @FXML
    private Label lblDorada;

    @FXML
    private Label lblGamba;

    @FXML
    private Label lblLenguado;

    @FXML
    private Label lblLubina;

    @FXML
    private Label lblMerluza;

    @FXML
    private Label lblPulpo;

    @FXML
    private Label lblSalmon;

    @FXML
    private Label lblSardina;

    @FXML
    private Label lblSepia;

    @FXML
    private Label lblTrucha;

    @FXML
    private Label lblUsuarioLogo;

    @FXML
    private Pane panelInfo;

    @FXML
    private Pane panelPrincipal;

    @FXML
    private Spinner<Integer> spinnerAñadir;

    @FXML
    private Spinner<Integer> spinnerEliminar;

    @FXML
    private Label lblInfoPescado;

    @FXML
    private Label lblInfoDescripcion;

    @FXML
    private ImageView imgInfoPescado;

    @FXML
    private Button btnPescadoActualizar;

    @FXML
    private Label lblMensajeError;

    private String pescadoActual;

    @FXML
    private Label lblStockActualizado;

    @FXML
    private void initialize() {
        configurarInfoPescado();
        controlStock();
    }

    public void usuarioConectado(String usuario) {
        lblUsuarioLogo.setText("Bienvenid@, " + usuario);
    }

    private void mostrarInfoPescado(String info, String imagen, String descripcion, String pescado) {
        lblInfoPescado.setText(info);
        imgInfoPescado.setImage(new Image(imagen));
        lblInfoDescripcion.setText(descripcion);
        pescadoActual = pescado;
    }

    private void configurarInfoPescado() {
        imgBacalao.setOnMouseClicked(e -> mostrarInfoPescado("INFO BACALAO", "bacalao.png", "Bacalaos traídos principalmente del mar cantábrico, Hay un stock de " + StockDAO.obtenerStockActual("BACALAO"), "BACALAO"));
        imgBoqueron.setOnMouseClicked(e -> mostrarInfoPescado("INFO BOQUERON", "boqueron.png", "Boquerones traídos principalmente de las costas andaluzas, Hay un stock de " + StockDAO.obtenerStockActual("BOQUERON"), "BOQUERON"));
        imgDorada.setOnMouseClicked(e -> mostrarInfoPescado("INFO DORADA", "dorada.png", "Doradas traídas principalmente del mar cantábrico, Hay un stock de " + StockDAO.obtenerStockActual("DORADA"), "DORADA"));
        imgGamba.setOnMouseClicked(e -> mostrarInfoPescado("INFO GAMBA", "gamba.png", "Gambas traídas principalmente de las costas gallegas, Hay un stock de " + StockDAO.obtenerStockActual("GAMBA"), "GAMBA"));
        imgLenguado.setOnMouseClicked(e -> mostrarInfoPescado("INFO LENGUADO", "lenguado.png", "Lenguados traídos principalmente del mar mediterráneo, Hay un stock de " + StockDAO.obtenerStockActual("LENGUADO"), "LENGUADO"));
        imgLubina.setOnMouseClicked(e -> mostrarInfoPescado("INFO LUBINA", "lubina.png", "Lubinas traídas principalmente de las costas francesas, Hay un stock de " + StockDAO.obtenerStockActual("LUBINA"), "LUBINA"));
        imgMerluza.setOnMouseClicked(e -> mostrarInfoPescado("INFO MERLUZA", "merluza.png", "Merluzas traídas principalmente del océano atlántico, Hay un stock de " + StockDAO.obtenerStockActual("MERLUZA"), "MERLUZA"));
        imgPulpo.setOnMouseClicked(e -> mostrarInfoPescado("INFO PULPO", "pulpo.png", "Pulpos traídos principalmente de las costas gallegas, Hay un stock de " + StockDAO.obtenerStockActual("PULPO"), "PULPO"));
        imgSalmon.setOnMouseClicked(e -> mostrarInfoPescado("INFO SALMON", "salmon.png", "Salmones traídos principalmente de las costas noruegas, Hay un stock de " + StockDAO.obtenerStockActual("SALMON"), "SALMON"));
        imgSardina.setOnMouseClicked(e -> mostrarInfoPescado("INFO SARDINA", "sardina.png", "Sardinas traídas principalmente del mar cantábrico, Hay un stock de " + StockDAO.obtenerStockActual("SARDINA"), "SARDINA"));
        imgSepia.setOnMouseClicked(e -> mostrarInfoPescado("INFO SEPIA", "sepia.png", "Sepias traídas principalmente de piscifactorías, Hay un stock de " + StockDAO.obtenerStockActual("SEPIA"), "SEPIA"));
        imgTrucha.setOnMouseClicked(e -> mostrarInfoPescado("INFO TRUCHA", "trucha.png", "Truchas traídas principalmente de los ríos españoles, Hay un stock de " + StockDAO.obtenerStockActual("TRUCHA"), "TRUCHA"));
    }


    private void controlStock() {
        controlSpinner();
        btnPescadoActualizar.setOnMouseClicked(e -> {
            if (spinnerAñadir.getValue() > 0 && spinnerEliminar.getValue() == 0) {
                StockDAO.actualizarStock(pescadoActual, spinnerAñadir.getValue());
            } else if (spinnerEliminar.getValue() < 0 && spinnerAñadir.getValue() == 0) {
                StockDAO.actualizarStock(pescadoActual, spinnerEliminar.getValue());
            } else {
                // Crear la animación de desvanecimiento
                FadeTransition fadeTransition = new FadeTransition(Duration.seconds(4), lblMensajeError);
                fadeTransition.setFromValue(1.0);
                fadeTransition.setToValue(0.0);
                lblMensajeError.setText("Solo se puede seleccionar una opción a la vez, la otra debe estar en 0");
                fadeTransition.play();
            }
        });

    }

    private void controlSpinner() {
        SpinnerValueFactory<Integer> valueFactory1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        SpinnerValueFactory<Integer> valueFactory2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(-100, 0, 0);
        spinnerAñadir.setValueFactory(valueFactory1);
        spinnerEliminar.setValueFactory(valueFactory2);
    }
}
