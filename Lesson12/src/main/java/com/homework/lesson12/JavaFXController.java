package com.homework.lesson12;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class JavaFXController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}