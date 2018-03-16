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
public class ModifyController {

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

        ObservableList imgList = FXCollections.observableArrayList(new ArrayList<String>());

        imgList.add("./images/Lloroso.png");
        imgList.add("./images/Pregunta.png");
        imgList.add("./images/Sonriente.png");
        imageDropdown.setItems(imgList);
    }

    @FXML
    void modifyPerson(ObservableList<Person> observableList, int i) {
        list = observableList;
        index = i;

        person = list.get(index);

        idField.setText(person.getIdAsString());
        nameField.setText(person.getFullName());
        cityField.setText(person.getResidence().getCity());
        provinceField.setText(person.getResidence().getProvince());
        imageDropdown.getSelectionModel().select(person.getPathImage());

    }

    @FXML
    void onCancelPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) cancelButton.fire();
    }

    @FXML
    void onOkPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) okButton.fire();
    }

    @FXML
    void okAction(ActionEvent event) throws IOException {
        //person.setFirstName(firstNameTextField.getText());
        //person.setLastName(lastNameTextField.getText());
        person.setId(Integer.parseInt(idField.getText()));
        person.setFullName(nameField.getText());
        person.setResidence(
                new Residence(
                        cityField.getText(),
                        provinceField.getText()
                )
        );
        person.setPathImage(imageDropdown.getSelectionModel().getSelectedItem().toString());
        //list.set(index, person);

        ((Node)(event.getSource())).getScene().getWindow().hide();

    }

    @FXML
    void cancelAction(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
}
