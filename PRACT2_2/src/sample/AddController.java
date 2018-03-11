package sample;

import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.IOException;

/**
 * Created by Oreki on 09/03/2018.
 */
public class AddController {

    @FXML
    private Button okButton;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private Button cancelButton;

    private ObservableList<Person> list;

    @FXML
    void initialize() {
        okButton.disableProperty().bind(
                Bindings.isEmpty(firstNameTextField.textProperty())
        );
        okButton.disableProperty().bind(
                Bindings.isEmpty(lastNameTextField.textProperty())
        );
    }

    void addPerson(ObservableList<Person> observableGuestList) {
        list = observableGuestList;
    }

    @FXML
    void onCancelPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) cancelButton.fire();
    }

    @FXML
    void onOkPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) okButton.fire();
    }
    //No se cierra al aceptar para facilitar la introduccion de grandes cantidades de personas
    @FXML
    void okAction(ActionEvent event) throws IOException {
        list.add(
                new Person(
                        firstNameTextField.getText(),
                        lastNameTextField.getText()
                )
        );

        lastNameTextField.clear();
        firstNameTextField.clear();
    }

    @FXML
    void cancelAction(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

}
