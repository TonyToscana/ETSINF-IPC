package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;


public class Add {
    Principal principal;

    @FXML
    private Button id_ok;

    @FXML
    private TextField id_lastName;

    @FXML
    private TextField id_firstName;

    @FXML
    private Button id_cancel;
    private ObservableList<Person> list;

    @FXML
    void event_ok(ActionEvent event) throws IOException {
        String last_name =id_lastName.getText();
        String first_name =id_firstName.getText();

        Person per = new Person(first_name,last_name);

        FXMLLoader loader=new FXMLLoader(getClass().getResource("principal.fxml"));
        Parent root = loader.load();
        Principal firController=loader.getController();
        System.out.println(String.valueOf(firController));
        //firController.namesListAdd(per);
        this.list.add(per);

    }

    @FXML
    void event_cancel(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    void init(ObservableList<Person> list){
        this.list = list;
    }

}