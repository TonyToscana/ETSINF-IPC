package sample;

/**
 * Sample Skeleton for 'sample.fxml' Controller Class
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Controller {

    @FXML // fx:id="idOpcionesEbay"
    private RadioMenuItem idOpcionesEbay; // Value injected by FXMLLoader

    @FXML // fx:id="idOpcionesAmazon"
    private RadioMenuItem idOpcionesAmazon; // Value injected by FXMLLoader

    @FXML // fx:id="idToolbar"
    private ToolBar idToolbar; // Value injected by FXMLLoader

    @FXML // fx:id="idState"
    private Label idState; // Value injected by FXMLLoader

    @FXML
    void eSalir(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmación");
        alert.setHeaderText("Vas a salir del programa");
        alert.setContentText("¿Seguro que quieres salir?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            // get a handle to the stage
            Stage stage = (Stage) idToolbar.getScene().getWindow();
            // do what you have to do
            stage.close();

        } else {
            System.out.println("CANCEL");
        }
    }

    @FXML
    void eAmazon(ActionEvent event) {
        confirmationAlert(idOpcionesAmazon);

    }

    @FXML
    void eBlogger(ActionEvent event) {
        List<String> choices = new ArrayList<>();
        choices.add("Blog de Arthos");
        choices.add("Blog de Porthos");
        choices.add("Blog de Aramis");

        ChoiceDialog<String> dialog = new ChoiceDialog<>("Blog de Arthos", choices);
        dialog.setTitle("Selecciona un blog");
        dialog.setHeaderText("¿Que blog quieres visitar?");
        dialog.setContentText("Elige:");
        Optional<String> result = dialog.showAndWait();
        // Obteniendo el resultado con una lambda
        result.ifPresent(number-> idState.textProperty().set(number));
    }

    @FXML
    void eEbay(ActionEvent event) {
        confirmationAlert(idOpcionesEbay);
    }

    @FXML
    void eFacebook(ActionEvent event) {
        TextInputDialog dialog = new TextInputDialog("Pepe"); // Por defecto
        dialog.setTitle("Introduce tu nombre");
        dialog.setHeaderText("¿Con que usuario quieres escribir en Facebook?");
        dialog.setContentText("Introduce tu nombre:");
        Optional<String> result = dialog.showAndWait();
        // Obteniendo el resultado con una lambda
        result.ifPresent(nombre -> idState.textProperty().set("Mensaje enviado como " + nombre));

    }

    void confirmationAlert(RadioMenuItem id){
        String name = id.getText();
        if (id.selectedProperty().getValue()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmación");
            alert.setHeaderText("Compra realizada correctamente");
            alert.setContentText("Has comprado en " + name);
            ButtonType button1 = new ButtonType("Ok");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error en la selección");
            alert.setHeaderText("No puede comprar en " + name);
            alert.setContentText("Por favor, cambie la sesion actual en el menu de opciones");
            ButtonType button1 = new ButtonType("Ok");
            alert.showAndWait();
        }
    }
}

