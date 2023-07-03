package com.example.lightcityfloat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class TomordehBoodiKeController {

    @FXML
    private Button acceptButton;

    public void AcceptButtonAction(ActionEvent event) {
        Stage stage = (Stage) acceptButton.getScene().getWindow();
        stage.close();

    }
}
