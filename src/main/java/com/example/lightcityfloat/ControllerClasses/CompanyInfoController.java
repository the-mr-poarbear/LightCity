package com.example.lightcityfloat.ControllerClasses;

import com.example.lightcityfloat.*;
import com.example.lightcityfloat.Character;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CompanyInfoController implements Initializable {

    @FXML
    private Button closeButton ;
    @FXML
    private Button recruitmentButton ;
    @FXML
    private Label infoLabel;
    @FXML
    private Label warningLabel;

    private Company currentCompany;
    private Character character;
    public void CompanyInfoWindowAction(ActionEvent event){
        Company company = ConvertFXMLtoOBJ.ButtonToCompany(((Button)event. getSource()).getId());
        currentCompany = company;
        infoLabel.setText(company.toString());

        character = DashBoard.Currentcharacter;
        if(character.getID() == 1){
            if (currentCompany.getStatus().equals("Recruitmentaion") ){

                recruitmentButton.setText("Recruitmenting");
            } else if(!currentCompany.getStatus().equals("Recruitmentaion")  ){

                recruitmentButton.setText("Not Recruitmenting");
            }
        } else if (character.getID() != 1 && character.getWorkPlaceID().equals(company.getID())) {
            System.out.println("torokhoda");
            recruitmentButton.setText("Resignate");
        } else{
            recruitmentButton.setText("Getting Employed");
        }

    }
    public void RecruitmentAction(ActionEvent event) throws IOException {

        if(character.getID() == currentCompany.getOwnerID()){
            if  (! currentCompany.getStatus().equals("Recruitmentaion") ){
                currentCompany.setStatus("Recruitmentaion");
                recruitmentButton.setText("Recruitmenting");
                DataBaseOperations.Update("company" , "Status" , currentCompany.getStatus() , currentCompany.getID() );
            } else if(currentCompany.getStatus().equals("Recruitmentaion")){
                currentCompany.setStatus("Idle");
                recruitmentButton.setText("Not Recruitmenting");
                DataBaseOperations.Update("company" , "Status" , currentCompany.getStatus() , currentCompany.getID() );
            }
        } else {
            System.out.println("salam");
            if (character.getWorkPlaceID().equals(currentCompany.getID())) {
                System.out.println("Khoobi?");
                character.setWorkPlaceID("no_ID");
                character.setJob("no_job");

                System.out.println(character.getJob());
                recruitmentButton.setText("Getting Employed");
                DataBaseOperations.Update("character", "WorkPlaceID", character.getWorkPlaceID(), character.getID());
                DataBaseOperations.Update("character", "Job", character.getJob(), character.getID());
                System.out.println("Naa");
            }
             else if(currentCompany.getStatus().equals("Recruitmentaion" )) {
                 System.out.println("dashi");
                 character.setWorkPlaceID(currentCompany.getID());
                character.setJob(currentCompany.getName());
                 recruitmentButton.setText("Resignate");
                 DataBaseOperations.Update("character","WorkPlaceID" , character.getWorkPlaceID() , character.getID());
                 DataBaseOperations.Update("character","Job" , character.getJob() , character.getID());
                 System.out.println("dash");
             }
        }




    }

    public void CloseButtonAction(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public void OptionButtonAction(ActionEvent event) {
    }
    public void BuySellButtonAction(ActionEvent event){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void payEmplyeeAction(ActionEvent event) {
        if(currentCompany.getOwnerID() == character.getID()){
            DataBaseOperations.PayEmployees(currentCompany.getID() , currentCompany.getIncome());
            character.setMoney(character.getMoney() + currentCompany.getIncome()/2);
            DataBaseOperations.Update("character" , "money" , character.getMoney() ,character.getID());

            currentCompany.setIncome(0);
            DataBaseOperations.Update("company" , "Income" , currentCompany.getIncome() , currentCompany.getID());

            warningLabel.setText("Successfully Paid");
        } else {
            warningLabel.setText("Buy The Company To Feed The Some Family");
        }

    }
}
