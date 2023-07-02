package com.example.lightcityfloat.ControllerClasses;

import com.example.lightcityfloat.Game;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PopupCityNameController {

    @FXML
    private Button okButton;
    @FXML
    private TextField cityNameTextField;


    public void OkButtonAction(ActionEvent event){
        try{
            Stage stage = (Stage) okButton.getScene().getWindow();
            stage.close();
            System.out.println("going to be build");
            Game.buildCity(cityNameTextField.getText());
        }
        catch (Exception e){
            System.out.println("it was cought");
        }

    }


    //Exit
    public void CancelButtonAction(ActionEvent event){
        Stage stage = (Stage) okButton.getScene().getWindow();
        stage.close();
    }
}
