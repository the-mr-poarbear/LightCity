package com.example.lightcityfloat.ControllerClasses;

import com.example.lightcityfloat.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class YouDiedController {

    @FXML
    private Button acceptButton;

    public static void YouDied() throws IOException {
        SceneOperators.SwitchSceneAction("YouDied.fxml" , true);

    }

    public void AcceptButtonAction(ActionEvent event) {
        Stage stage = (Stage) acceptButton.getScene().getWindow();
        stage.close();
        System.exit(0);
    }
}
