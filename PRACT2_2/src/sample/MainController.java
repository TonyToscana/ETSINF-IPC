package sample;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Paint;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;

public class MainController {

    @FXML
    private ListView<Person> guestListView;

    @FXML
    private Button addButton;

    @FXML
    private Button removeButton;

    @FXML
    private Button modifyButton;

    private ObservableList<Person> observableGuestList;
    private final String[] KONAMI_CODE = {"UP", "UP", "DOWN", "DOWN", "LEFT", "RIGHT", "LEFT", "RIGHT", "B", "A"};
    private int estado = 0;


    public void initialize() {
        observableGuestList = FXCollections.observableArrayList(new ArrayList<Person>());

        observableGuestList.add(new Person("Miguel", "Edo"));
        observableGuestList.add(new Person("Borja", "Palomo"));

        removeButton.disableProperty().bind(
                Bindings.isEmpty(guestListView.getSelectionModel().getSelectedItems())
        );

        modifyButton.disableProperty().bind(
                Bindings.isEmpty(guestListView.getSelectionModel().getSelectedItems())
        );

        guestListView.setItems(observableGuestList);
    }

    @FXML
    void addPerson(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddController.fxml"));
        Parent root = loader.load();
        AddController addController = loader.getController();

        addController.addPerson(observableGuestList);
        Stage stage=new Stage();
        stage.setTitle("Add a person");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    void removePerson(ActionEvent event) {
        observableGuestList.remove(
                guestListView.getSelectionModel().getSelectedIndex()
        );
    }

    @FXML
    void modifyPerson(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifyController.fxml"));
        Parent root = loader.load();
        ModifyController modifyController = loader.getController();

        modifyController.modifyPerson(
                observableGuestList,
                guestListView.getSelectionModel().getSelectedIndex()
        );
        Stage stage = new Stage();
        stage.setTitle("Modify a person");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
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
    }

    private void checkKonamiCode(KeyCode code) {
        if (KONAMI_CODE[estado].equals(code.toString())) {
            ++estado;
        } else estado = 0;

        if (estado == 10) {
            onExecutedKonamiCode();
            estado = 0;
        }
    }

    //Add Doe family
    private void onExecutedKonamiCode() {
        observableGuestList.addAll(
                new Person("John", "Doe"),
                new Person("Jane", "Doe"),
                new Person("Johnny", "Doe"),
                new Person("Janie", "Doe"),
                new Person("Baby", "Doe")
        );
    }
}
