package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import sun.plugin2.jvm.RemoteJVMLauncher;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class Controller implements Initializable{

    @FXML
    private ListView<String> cardsList;
    private ObservableList<String> data;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        cardsList.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                return null;
            }
        });





            data = FXCollections.observableArrayList ();



        cardsList.setItems(data);



    }
}
