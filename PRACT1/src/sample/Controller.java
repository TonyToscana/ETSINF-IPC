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

    int column, row;
    //private static final String konamiCode = "";


    public void initialize(URL url, ResourceBundle rb) {
        column = GridPane.getColumnIndex(circleBolita);
        row = GridPane.getRowIndex(circleBolita);
    }

    @FXML
    private void handleKeyPressedBolita(KeyEvent event) {
        switch (event.getCode()) {
            case DOWN:
                if (!(row == 4)) {
                    GridPane.setRowIndex(circleBolita, ++row);
                }
                break;
            case UP:
                if (!(row == 0)) {
                    GridPane.setRowIndex(circleBolita, --row);
                }
                break;
            case LEFT:
                if (!(column == 0)) {
                    GridPane.setColumnIndex(circleBolita, --column);
                }
                break;
            case RIGHT:
                if (!(column == 4)) {
                    GridPane.setColumnIndex(circleBolita, ++column);
                }
                break;
            default:
                System.out.println("Bad key pressed");
                break;

        }
    }
}
