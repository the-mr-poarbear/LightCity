package com.example.lightcityfloat.ControllerClasses;

import com.example.lightcityfloat.Game;
import com.example.lightcityfloat.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class GameMenuController {

    @FXML
    private Button closeButton;

    public void ContinueButtonAction(ActionEvent event){
        //set City Connectionnnnnnnnnn!!!!!!!!!!!!!!!!!
        try{
            SceneOperators.SwitchSceneAction("ContinueCity.fxml" , false);

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public void JoinCityAction(ActionEvent event){

        try{
            SceneOperators.SwitchSceneAction("JoinCity.fxml" , false);

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void BuildCityAction(ActionEvent event) throws IOException {
        try{
            SceneOperators.SwitchSceneAction("buildCityGUI.fxml" , false);
            //SwitchSceneAction("cityGUI.fxml" , true);

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }


    //Exit
    public void CloseButtonAction(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }



}
