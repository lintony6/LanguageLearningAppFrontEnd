package controllers;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.*;
import javafx.scene.paint.Color;


public class HomepageController {
    @FXML private BorderPane root;
    @FXML private Text homepageText, descriptionText;
    private LanguageLearningSystemFacade facade;
    @FXML
    private Label welcomeLabel;

    /**
     * Initializes the homepage with the logged-in user's information.
     * @param user The logged-in user.
     */
    public void initialize() {
        facade = LanguageLearningSystemFacade.getInstance();
        facade.login("JimSmith01", "SmithRocks");
        facade.getUser().getSettings().setLightMode(0);
        // Example: Use user data to personalize the homepage
        String welcomeMessage = "Welcome, " + facade.getUser().getFirstName() + "!";
        welcomeLabel = new Label();
        welcomeLabel.setText(welcomeMessage);
        PauseTransition delay = new PauseTransition(Duration.seconds(0.3)); 
        delay.setOnFinished(event -> showAlert(welcomeMessage));
        delay.play();
        if(facade.getUser().getSettings().getLightMode() == 0) {
            root.setStyle("-fx-background-color: #36454F;");
            homepageText.setFill(Color.WHITE);
            descriptionText.setFill(Color.WHITE);
        }

    }

    @FXML
    private void openSettings(ActionEvent event) {
        changePage("/library/Settings.fxml");
        // Logic to open Settings screen
    }

    @FXML
    private void logout(ActionEvent event) {
        showAlert("Logging out...");
        // Logic to navigate to Login screen
    }

    @FXML
    private void startLesson(ActionEvent event) {
        if(facade.getLanguage() == null) {
            showAlert("Please select a language and difficulty level first.");
            return;
        }
        changePage("/library/ChooseLesson.fxml");
        // Logic to start a lesson
    }

    @FXML
    private void selectLanguage(ActionEvent event) {
        changePage("/library/ChooseLanguage.fxml");
        // Logic for language selection
    }

    @FXML
    private void viewUserProfile(ActionEvent event) {
        changePage("/library/UserProfile.fxml");
        // Logic to view the user's profile
    }

    @FXML
    private void selectDifficulty(ActionEvent event) {
        if(facade.getLanguage() == null) {
            showAlert("Please select a language first.");
            return;
        }
        changePage("/library/ChooseDifficulty.fxml");
        // Logic for selecting difficulty
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }

          @FXML
    public void changePage(String file) {
        try {
            // Load the login.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource(file));
            Parent root = loader.load();
            // Get the current stage
            Stage stage = (Stage) this.root.getScene().getWindow();
            stage.setScene(new Scene(root, 800, 800));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
