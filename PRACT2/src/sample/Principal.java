package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Principal {
    private static ObservableList<Person> namesList;

    @FXML
    private ListView<Person> id_namesList;

    @FXML
    private Button id_add;

    @FXML
    private Button id_remove;

    @FXML
    private Button id_modify;

    class PersonCall extends ListCell<Person> {
        @Override
        public void updateItem(Person p, boolean e) {
            if (p == null || e) {
                setText(null);
            } else {
                setText(p.getFirstName() + ", " + p.getLastName());
            }
        }
    }

    //@Override
    public void initialize(){
        namesList = FXCollections.observableArrayList(new ArrayList<Person>());
        namesList.add(new Person("Miguel", "Edo"));
        namesList.add(new Person("Borja", "Palomo"));
        id_namesList.setItems(namesList);

        id_namesList.setCellFactory((c) -> { return new PersonCall(); } );
    }

    public void namesListAdd(Person per){
        System.out.println(per.getFirstName() );
        namesList.add(new Person("sf2", "sdlkfj"));
        id_namesList.getItems().add(per);
        System.out.print(namesList.toString());
        id_namesList.setItems(namesList);

    }


    @FXML
    void event_add(ActionEvent event) throws IOException {
        System.out.println(String.valueOf(this));
            FXMLLoader loader=new FXMLLoader(getClass().getResource("add.fxml"));
            Parent root = loader.load();
            Add secController=loader.getController();

            secController.init(namesList);
            Stage stage=new Stage();
            stage.setTitle("Modify a person");
            stage.initModality(Modality.WINDOW_MODAL);
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.show();

    }
    @FXML
    void event_remove(ActionEvent event) {

    }

    @FXML
    void event_modify(ActionEvent event) {

    }


}
