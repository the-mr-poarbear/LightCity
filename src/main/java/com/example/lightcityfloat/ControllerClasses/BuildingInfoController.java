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

public class BuildingInfoController implements Initializable {

    @FXML
    private Button Building1;
    @FXML
    private Button buyOrSellBuildingButton;
    @FXML
    private Label InfoWindowLableBuilding;
    @FXML
    private Button okButton;
    @FXML
    private Label warningLabel;

    private Area area;

    ActionEvent storedEvent ;

   // CityBuildingSelectionController  b = SceneOperators.fxmlLoaderr.getController();

    private Character character = DashBoard.Currentcharacter;

    public BuildingInfoController() throws IOException {
    }

    public void BuildingInfoWindowAction(ActionEvent event ){
        storedEvent = event;
        System.out.println("Building Number " +  ((Button)event. getSource()).getId() + " Was Selected  " );
        area = ConvertFXMLtoOBJ.ButtonToBuilding(((Button)event. getSource()).getId());
        InfoWindowLableBuilding.setText(area.toString());


        if(character.getID() == area.getOwnerID() && !area.isForSale()){
            buyOrSellBuildingButton.setText("Sell");
        } else if (character.getID() == area.getOwnerID() && area.isForSale()) {

            buyOrSellBuildingButton.setText("Is On Sale");
        } else if (!area.isForSale()) {
            buyOrSellBuildingButton.setText("Not For Sale");
        }

        System.out.println("doops");

    }

    public void OkButtonAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) okButton.getScene().getWindow();
        stage.close();
        SceneOperators.SwitchSceneAction("cityGUIv3.fxml",true);

    }

    public void WarningLabelAction(ActionEvent event){
        if (buyOrSellBuildingButton.isDisable()){

        }

    }

    public void BuyButtonAction(){
        if (area.isForSale() && area.getPrice() <= character.getMoney() && area.getOwnerID() != character.getID()){


            area.setForSale(false);
            character.setMoney(character.getMoney()-area.getPrice());
            buyOrSellBuildingButton.setText("Sell");
            String areasID = Character.AreasToID(character.getAreasOwned()) ;

            DataBaseOperations.BankTransaction(character.getID(), area.getOwnerID(), area.getPrice() );
            //IMPORTANT!!! when someone buys a place the money wont directly goes to the prevoise owner
            // ..it goes to bank with previous owner's ID and the previous owner can go get thair money from there
           // DataBaseOperations.Update("character" , "money" , areasID , character.getID() );
            area.setOwnerID(character.getID());
            DataBaseOperations.Update("character" , "money" , character.getMoney() , character.getID() );
            DataBaseOperations.Update("character" , "AreasOwnedID" , areasID , character.getID() );
            DataBaseOperations.Update("area" , "ForSale" , false ,area.getID() );
            DataBaseOperations.Update("area" , "OwnerID" , character.getID() ,area.getID() );

            character.getAreasOwned().add(area);
        } else if (!area.isForSale() && character.getID() != area.getOwnerID()) {
            warningLabel.setText("This Place Is Not For Sale");
        } else if (area.getPrice() > character.getMoney()) {
            warningLabel.setText("You Don't Have Enough Money");
        } else if (character.getID() == area.getOwnerID() && !area.isForSale()) {
            area.setForSale(true);
            DataBaseOperations.Update("area" , "ForSale" , true ,area.getID() );
            buyOrSellBuildingButton.setText("Is On Sale2");
        } else if(character.getID() == area.getOwnerID() && area.isForSale()){
            area.setForSale(true);
            DataBaseOperations.Update("area" , "ForSale" , false ,area.getID() );
            buyOrSellBuildingButton.setText("Not For Sale");
        }

        //CityBuildingSelectionController.cityBarUpdate();
    }

    public void BuildingConstructorAction(ActionEvent event) throws IOException {
        if (area.getOwnerID() == character.getID()){
            BuildingConstructorController b =  SceneOperators.SwitchSceneAction("BuildingConstructorWindow.fxml" , false).getController();
            b.setBuildingButtonEventRefrence(storedEvent);
        } else {
            warningLabel.setText("You Can Not Access Building Constructor Untill You Buy It");
        }
       // CityBuildingSelectionController.cityBarUpdate();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
      /*  if(area.getOwnerID() == character.getID()){
            buyOrSellBuildingButton.setText("Sell");
        }*/

    }



    public void s(){
        System.out.println("salam");
    }


}
