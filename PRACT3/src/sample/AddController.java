package sample;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Oreki on 09/03/2018.
 */
public class AddController {

    @FXML
    private Button okButton;

    @FXML
    private TextField idField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField cityField;

    @FXML
    private TextField provinceField;

    @FXML
    private ComboBox imageDropdown;

    @FXML
    private Button cancelButton;

    private ObservableList<Person> list;
    private int index;
    private Person person;

    @FXML
    void initialize() {
        okButton.disableProperty().bind(
                Bindings.isNull(imageDropdown.getSelectionModel().selectedItemProperty())
                .or(Bindings.isEmpty(nameField.textProperty())
                .or(Bindings.isEmpty(idField.textProperty())))
                .or(Bindings.isEmpty(cityField.textProperty()))
                .or(Bindings.isEmpty(provinceField.textProperty()))
        );

        //Temporary
        ObservableList list = FXCollections.observableArrayList(new ArrayList<String>());
        list.add("string");
        imageDropdown.setItems(list);
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
                        Integer.parseInt(idField.getText()),
                        nameField.getText(),
                        new Residence(cityField.getText(), provinceField.getText()),
                        imageDropdown.selectionModelProperty().getName()

                )
       );

       idField.clear();
       nameField.clear();
       cityField.clear();
       provinceField.clear();
       imageDropdown.getSelectionModel().clearSelection();
    }

    @FXML
    void cancelAction(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

}
