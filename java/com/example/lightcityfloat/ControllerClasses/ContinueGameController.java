package com.example.lightcityfloat.ControllerClasses;

import com.example.lightcityfloat.Game;
import com.example.lightcityfloat.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ContinueGameController {
    @FXML
    private Button okButton ;
    @FXML
    private Button cancelButton;
    @FXML
    private TextField urlTextField;

    public void OkButtonAction(ActionEvent event){


        Stage stage = (Stage) okButton.getScene().getWindow();
        stage.close();
        String url = urlTextField.getText();
        String username = Login.Username;
        Game.Continue(url , username);


    }

    public void CancelButtonAction(ActionEvent event){
        Stage stage = (Stage) okButton.getScene().getWindow();
        stage.close();
    }


}
