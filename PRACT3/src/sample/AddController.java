package sample;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
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

    @FXML
    private Label warningLabel;

    private ObservableList<Person> list;

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
        imageDropdown.setCellFactory( cell -> new ListCell<String>(){
            private ImageView view = new ImageView();
            @Override
            protected void updateItem( String item, boolean empty){
                super.updateItem(item, empty);
                if(item==null || empty){
                    setGraphic(null);
                }
                else{
                    Image image = new Image(MainController.class.getResourceAsStream(item),
                            40,40,true,true);
                    view.setImage(image);
                    setGraphic(view);
                }
            }
        });
        imageDropdown.setButtonCell(new ListCell<String>(){
            private ImageView view = new ImageView();
            @Override
            protected void updateItem( String item, boolean empty){
                super.updateItem(item, empty);
                if(item==null || empty){
                    setGraphic(null);
                }
                else{
                    Image image = new Image(MainController.class.getResourceAsStream(item),
                            40,40,true,true);
                    view.setImage(image);
                    setGraphic(view);
                }
            }
        });
    }

    @FXML
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
        if(!existsId(Integer.parseInt(idField.getText()))) {
            warningLabel.setVisible(false);
            list.add(
                new Person(
                Integer.parseInt(idField.getText()),
                nameField.getText(),
                new Residence(cityField.getText(), provinceField.getText()),
                imageDropdown.getSelectionModel().getSelectedItem().toString()
                )
            );

            idField.clear();
            nameField.clear();
            cityField.clear();
            provinceField.clear();
            imageDropdown.getSelectionModel().clearSelection();
        } else warningLabel.setVisible(true);
    }

    @FXML
    void cancelAction(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    boolean existsId(int id) {
        for (Person p:
             list) {
            if(p.getId() == id) return true;
        }
        return false;
    }

}
