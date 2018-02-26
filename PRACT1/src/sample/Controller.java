package sample;

import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller {
    @FXML
    private Circle circleBolita;
    @FXML
    private GridPane gridBolita;

    int column, row;
    private static final String konamiCode = "UPUPDOWNDOWNLEFTRIGHTLEFTRIGHTBA";
    private final String[] COLORS = {"RED", "BLUE", "GREEN", "BLACK", "GRAY", "PURPLE", "PINK", "GOLD", "SILVER"};
    private String buffer = "";

    public void initialize() {
        column = GridPane.getColumnIndex(circleBolita);
        row = GridPane.getRowIndex(circleBolita);
    }

    @FXML
    private void handleKeyPressedBolita(KeyEvent event) {
        switch (event.getCode()) {
            case DOWN:
                buffer += event.getCode();
                checkKonamiCode();
                if (!(row == 4)) {
                    GridPane.setRowIndex(circleBolita, ++row);
                }
                break;
            case UP:
                buffer += event.getCode();
                checkKonamiCode();
                if (!(row == 0)) {
                    GridPane.setRowIndex(circleBolita, --row);
                }
                break;
            case LEFT:
                buffer += event.getCode();
                checkKonamiCode();
                if (!(column == 0)) {
                    GridPane.setColumnIndex(circleBolita, --column);
                }
                break;
            case RIGHT:
                buffer += event.getCode();
                checkKonamiCode();
                if (!(column == 4)) {
                    GridPane.setColumnIndex(circleBolita, ++column);
                }
                break;
            default:
                buffer += event.getCode();
                checkKonamiCode();
                System.out.println(buffer);
                break;

        }
    }

    private void checkKonamiCode(){
        if ((buffer.length() >= konamiCode.length()) &&
                (buffer.substring(buffer.length()-konamiCode.length()).equals(konamiCode))) {
            circleBolita.setFill(Paint.valueOf(COLORS[(int) (Math.random() * 9)]));
            buffer = "";
        }

    }
}
