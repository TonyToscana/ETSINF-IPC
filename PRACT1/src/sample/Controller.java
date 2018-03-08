package sample;

import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class Controller {
    @FXML
    private Circle circleBolita;
    @FXML
    private GridPane gridBolita;

    private int column, row;

    private final String[] KONAMI_CODE = {"UP", "UP", "DOWN", "DOWN", "LEFT", "RIGHT", "LEFT", "RIGHT", "B", "A"};
    private final String[] COLORS = {"RED", "BLUE", "GREEN", "BLACK", "GRAY", "PURPLE", "PINK", "GOLD", "SILVER"};
    private int estado = 0;

    public void initialize() {
        column = GridPane.getColumnIndex(circleBolita);
        row = GridPane.getRowIndex(circleBolita);
    }

    @FXML
    private void handleKeyPressedBolita(KeyEvent event) {
        switch (event.getCode()) {
            case DOWN:
                checkKonamiCode(event.getCode());
                if (!(row == 4)) {
                    GridPane.setRowIndex(circleBolita, ++row);
                }
                break;
            case UP:
                checkKonamiCode(event.getCode());
                if (!(row == 0)) {
                    GridPane.setRowIndex(circleBolita, --row);
                }
                break;
            case LEFT:
                checkKonamiCode(event.getCode());
                if (!(column == 0)) {
                    GridPane.setColumnIndex(circleBolita, --column);
                }
                break;
            case RIGHT:
                checkKonamiCode(event.getCode());
                if (!(column == 4)) {
                    GridPane.setColumnIndex(circleBolita, ++column);
                }
                break;
            default:
                checkKonamiCode(event.getCode());
                break;

        }
    }

    private void checkKonamiCode(KeyCode code){
        if (KONAMI_CODE[estado].equals(code.toString())) {
            ++estado;
        } else estado = 0;

        if (estado == 10) {
            circleBolita.setFill(Paint.valueOf(COLORS[(int) (Math.random() * COLORS.length)]));
            estado = 0;
        }
    }
}
