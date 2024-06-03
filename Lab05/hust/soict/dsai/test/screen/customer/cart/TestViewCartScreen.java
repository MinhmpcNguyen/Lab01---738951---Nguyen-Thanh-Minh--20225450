package hust.soict.dsai.test.screen.customer.cart;

import javax.naming.LimitExceededException;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.screen.customer.controller.CartController;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewCartScreen extends Application {
    private static Cart cart;
    private static Store store;
    @Override
    public void start(Stage stage) throws Exception {
        final String STORE_FXML_FILE_PATH = "/AimsProject/src/hust/soict/dsai/aims/screen/customer/view/Cart.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
        CartController cartController = new CartController(store,cart);
        fxmlLoader.setController(cartController);
        Parent root = fxmlLoader.load();

        stage.setTitle("Cart");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) throws LimitExceededException {
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        cart = new Cart();
        store = new Store();

        cart.addMedia(dvd3);
        store.addMedia(dvd3);
        launch(args);
    }

}
