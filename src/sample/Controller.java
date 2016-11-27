package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {


    @FXML
    private ImageView cardImg;

    /*ListView does not have ActionEvents. Instead it has a selectedItemProperty that contains the
    currenty selected item of the list. In JavaFX a Property is more than just a simple value.
    Each Property provides methods to observe changes made to its value. We can "listen for changes".
    This is how we handle such changes for a ListView:
     */
    @FXML
    private ListView<Card> cardsList;
    ObservableList<Card> items;



    public void initialize() throws IOException {

        API api = new API();
        ArrayList<Card> cards = api.getCartes();


        cardsList.setCellFactory(new Callback<ListView<Card>, ListCell<Card>>() {
            @Override
            public ListCell<Card> call(ListView<Card> param) {

                ListCell<Card> cell = new ListCell<Card>() {

                    @Override
                    protected void updateItem(Card card, boolean empty) {
                        super.updateItem(card, empty);
                        if(card!=null){
                            setText(card.getName());
                            cardImg.setImage(new Image(card.getImgURL()));
                        }
                    }
                };

                return cell;
            }
        });

        items = FXCollections.observableArrayList (cards);
        cardsList.setItems(items);

        // Handle ListView selection changes
        cardsList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            cardImg.setImage(new Image(newValue.getImgURL()));



        });

    }


}

