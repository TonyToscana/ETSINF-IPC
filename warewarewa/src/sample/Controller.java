package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.ArrayList;

public class Controller {

    @FXML
    private ListView<String> lista;

    private ObservableList<String> observableLista;

    public void initialize() {
        observableLista = FXCollections.observableArrayList(new ArrayList<String>());
        observableLista.add("Nombre");

        lista.setItems(observableLista);
    }

}
