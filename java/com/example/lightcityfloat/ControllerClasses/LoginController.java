package com.example.lightcityfloat.ControllerClasses;

import com.example.lightcityfloat.Game;
import com.example.lightcityfloat.Login;
import com.example.lightcityfloat.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Label loginMassageLabel ;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordPasswordField;
    @FXML
    private Button closeButton;


    //Exit
    public void CloseButtonAction(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public void LoginButtonAction(ActionEvent e){

        if(!usernameTextField.getText().isBlank() && !passwordPasswordField.getText().isBlank()){
            Login.Player(usernameTextField.getText() , passwordPasswordField.getText());


        } else {
            loginMassageLabel.setText("Please Fill The Required Fields");
        }

    }

    public void RegisterButtonAction(){
        if(!usernameTextField.getText().isBlank() && !passwordPasswordField.getText().isBlank()){
            Login.registery(usernameTextField.getText() , passwordPasswordField.getText());


        } else {
            loginMassageLabel.setText("Please Fill The Required Fields");
        }
    }







    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}