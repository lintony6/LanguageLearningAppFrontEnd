package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class HomepageController {

    @FXML
    private void openSettings(ActionEvent event) {
        showAlert("Navigating to Settings...");
        // Logic to open Settings screen
    }

    @FXML
    private void logout(ActionEvent event) {
        showAlert("Logging out...");
        // Logic to navigate to Login screen
    }

    @FXML
    private void startLesson(ActionEvent event) {
        showAlert("Starting Lessons...");
        // Logic to start a lesson
    }

    @FXML
    private void selectLanguage(ActionEvent event) {
        showAlert("Opening Language Selection...");
        // Logic for language selection
    }

    @FXML
    private void viewUserProfile(ActionEvent event) {
        showAlert("Opening User Profile...");
        // Logic to view the user's profile
    }

    @FXML
    private void selectDifficulty(ActionEvent event) {
        showAlert("Opening Difficulty Selection...");
        // Logic for selecting difficulty
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.showAndWait();
    }
}