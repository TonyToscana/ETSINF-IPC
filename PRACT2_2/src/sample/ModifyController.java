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
public class ModifyController {

    @FXML
    private Button okButton;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private Button cancelButton;

    private ObservableList<Person> guestObservableList;
    private int index;
    private Person person;

    @FXML
    void initialize() {
        okButton.disableProperty().bind(
                Bindings.isEmpty(firstNameTextField.textProperty())
        );
        okButton.disableProperty().bind(
                Bindings.isEmpty(lastNameTextField.textProperty())
        );
    }

    @FXML
    void onCancelPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) cancelButton.fire();
    }

    @FXML
    void onOkPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) okButton.fire();
    }

    void modifyPerson(ObservableList<Person> guestOL, int i) {
        guestObservableList = guestOL;
        index = i;

        person = guestObservableList.get(index);

        lastNameTextField.setText(person.getLastName());
        firstNameTextField.setText(person.getFirstName());
    }

    @FXML
    void okAction(ActionEvent event) throws IOException {
        person.setFirstName(firstNameTextField.getText());
        person.setLastName(lastNameTextField.getText());

        guestObservableList.set(index, person);

        ((Node)(event.getSource())).getScene().getWindow().hide();

    }

    @FXML
    void cancelAction(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
}
