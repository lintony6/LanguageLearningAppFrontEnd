package library;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    private static Scene scene;
    private static Stage stage;
    @Override
    public void start(Stage primaryStage) {
        try {
            // Load the Login.fxml file
            Parent root = FXMLLoader.load(getClass().getResource("/library/Login.fxml"));
            primaryStage.setTitle("Language Learning App");
            primaryStage.setScene(new Scene(root, 800, 800));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
