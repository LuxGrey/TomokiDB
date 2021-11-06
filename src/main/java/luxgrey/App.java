package luxgrey;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    public void init() {
        PersistenceHelper.init();
    }

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("IdentityList"), 1200, 800);
        stage.setScene(scene);
        stage.setTitle("TomokiDB");
        stage.setMinHeight(250);
        stage.setMinWidth(650);

        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = createFXMLLoader(fxml);
        return fxmlLoader.load();
    }

    public static FXMLLoader createFXMLLoader(String fxml) {
        return new FXMLLoader(App.class.getResource("fxml/" + fxml + ".fxml"));
    }

    public static void main(String[] args) {
        launch();
    }

}