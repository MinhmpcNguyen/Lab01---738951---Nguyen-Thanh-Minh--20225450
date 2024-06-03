package hust.soict.dsai.aims.screen.customer.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;

public class CartController {
    private Cart cart;
    private Store store;
    public CartController(Store store,Cart cart)
    {
        this.cart = cart;
        this.store = store;
    }

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private TextField tfFilter;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private Label costLabel;
    private ObservableList<Media> mediaList = FXCollections.observableArrayList();
    private FilteredList<Media> filteredData;



    @FXML
    private TableView<Media> tblMedia;

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        alert.setTitle("Playing Media");
        alert.setHeaderText(null);
        alert.setContentText("You are playing " + media.getTitle());
        alert.showAndWait();
    }

    @FXML
    void btnViewCartPressed(ActionEvent event) {
        try {
            final String CART_FXML_FILE_PATH = "/AimsProject/src/hust/soict/dsai/aims/screen/customer/view/Cart.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
            	fxmlLoader.setController(new CartController(store, cart));
            	Parent root = fxmlLoader.load();
            	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            	stage.setScene(new Scene(root));
            	stage.setTitle("Cart");
            	stage.show();
        } catch (IOException e) {
                e.printStackTrace();
        }

    }

    @FXML
    void btnOrderPressed()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Confirm order");
        alert.setHeaderText("Your Bill");
        StringBuilder billText = new StringBuilder();
        for(Media media:cart.getItemsOrdered())
        {
            billText.append(media.getTitle() + ": " + media.getCost()+"$");
            billText.append("\n");
        }
        billText.append("\n");
        billText.append("Total Cost: "+cart.totalCost()+"$");
        alert.setContentText(billText.toString());
        alert.showAndWait();
    }

    @FXML
    public void initialize() {
        colMediaId.setCellValueFactory(
                new PropertyValueFactory<Media, Integer>("id"));
        colMediaTitle.setCellValueFactory(
                new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(
                new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(
                new PropertyValueFactory<Media, Float>("cost"));
        if (cart.getItemsOrdered() != null)
            tblMedia.setItems(cart.getItemsOrdered());


        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observableValue, Media oldValue, Media newValue) {
                updateButtonBar(newValue);
            }
        });
        filteredData = new FilteredList<>(cart.getItemsOrdered(), p -> true);

        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                showFilterdMedia(newValue);
            }
        });
        
        cart.getItemsOrdered().addListener((ListChangeListener<Media>) change -> {
            while (change.next()) {
                updateCost();
            }
        });

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
        updateCost();
    }

    private void showFilterdMedia(String newvalue) {
        if (newvalue == null || newvalue.isEmpty()) {
            System.out.println("Null");
            filteredData.setPredicate(media -> true);
        } else {
            System.out.println("Not null");
            if (radioBtnFilterId.isSelected()) {
                filteredData.setPredicate(media -> String.valueOf(media.getId()).contains(newvalue));
                tblMedia.setItems(filteredData);
            } else if (radioBtnFilterTitle.isSelected()) {
                filteredData.setPredicate(media -> media.getTitle().toLowerCase().contains(newvalue.toLowerCase()));
                tblMedia.setItems(filteredData);
            }
        }
    }

    void updateButtonBar(Media media)
    {
        if(media == null)
        {
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        }
        else
        {
            btnRemove.setVisible(true);
            if(media instanceof Playable)
            {
                btnPlay.setVisible(true);
            }
            else
            {
                btnPlay.setVisible(false);
            }
        }
    }

    void updateCost()
    {
        StringBuilder cost = new StringBuilder();
        cost.append(cart.totalCost());
        cost.append(" $");
        costLabel.setText(cost.toString());
    }
    
    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
    }

}