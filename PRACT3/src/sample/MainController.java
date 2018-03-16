package sample;

import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import sample.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Paint;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainController {

    @FXML
    private TableView<Person> tableView;

    @FXML
    private TableColumn<Person, Integer> idColumn;

    @FXML
    private TableColumn<Person, String> nameColumn;

    @FXML
    private TableColumn<Person, String> cityColumn;

    @FXML
    private TableColumn<Person, String> imageColumn;

    @FXML
    private Button addButton;

    @FXML
    private Button removeButton;

    @FXML
    private Button modifyButton;

    private ObservableList<Person> observablePersonList;
    private final String[] KONAMI_CODE = {"UP", "UP", "DOWN", "DOWN", "LEFT", "RIGHT", "LEFT", "RIGHT", "B", "A"};
    private int estado = 0;


    public void initialize() {
        observablePersonList = FXCollections.observableArrayList(new ArrayList<Person>());

        removeButton.disableProperty().bind(
                Bindings.isEmpty(tableView.getSelectionModel().getSelectedItems())
        );

        modifyButton.disableProperty().bind(
                Bindings.isEmpty(tableView.getSelectionModel().getSelectedItems())
        );
        //####################################################################
        observablePersonList.add(new Person(
                1,
                "Maria Jose",
                new Residence("Ciudad", "Provincia"),
                "./images/Lloroso.png"
        ));
        observablePersonList.add(new Person(
                2,
                "Jose Maria",
                new Residence("Ciudadela", "Provincieta"),
                "./images/Sonriente.png"
        ));
        //####################################################################
        tableView.setItems(observablePersonList);

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        cityColumn.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getResidence().getCity().toUpperCase()));
        imageColumn.setCellValueFactory(celda4 -> celda4.getValue().pathImageProperty());
        imageColumn.setCellFactory( (TableColumn<Person, String> columna) -> new TableCell<Person,String>(){
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
    void addPerson(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddController.fxml"));
        Parent root = loader.load();
        AddController addController = loader.getController();

        addController.addPerson(observablePersonList);
        Stage stage=new Stage();
        stage.setTitle("Add a person");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void removePerson(ActionEvent event) {
        observablePersonList.remove(
                tableView.getSelectionModel().getSelectedIndex()
        );
    }

    @FXML
    void modifyPerson(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifyController.fxml"));
        Parent root = loader.load();
        ModifyController modifyController = loader.getController();

        modifyController.modifyPerson(
                observablePersonList,
                tableView.getSelectionModel().getSelectedIndex()
        );
        Stage stage = new Stage();
        stage.setTitle("Modify a person");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();
    }


















































   /* @FXML
    void onKeyPressed(KeyEvent event) {
        checkKonamiCode(event.getCode());
    }

    @FXML
    void onAddPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) addButton.fire();
    }

    @FXML
    void onRemovePressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) removeButton.fire();
    }

    @FXML
    void onModifyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) modifyButton.fire();
    }*/

    /*private void checkKonamiCode(KeyCode code) {
        if (KONAMI_CODE[estado].equals(code.toString())) {
            ++estado;
        } else estado = 0;

        if (estado == 10) {
            //onExecutedKonamiCode();
            estado = 0;
        }
    }*/

    //Add Doe family
    /*private void onExecutedKonamiCode() {
        observableGuestList.addAll(
                new Person("John", "Doe"),
                new Person("Jane", "Doe"),
                new Person("Johnny", "Doe"),
                new Person("Janie", "Doe"),
                new Person("Baby", "Doe")
        );
    }*/
}
