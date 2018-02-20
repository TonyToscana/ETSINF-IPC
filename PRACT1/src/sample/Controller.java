package sample;

import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller {
    @FXML
    private Circle circleBolita;
    @FXML
    private GridPane gridBolita;

    int column, fila;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void handleKeyPressedBolita(KeyEvent event) {

    }
}
