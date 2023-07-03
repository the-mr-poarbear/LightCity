package com.example.lightcityfloat.ControllerClasses;

import com.example.lightcityfloat.*;
import com.example.lightcityfloat.Character;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class BuildingConstructorController implements Initializable {

    @FXML
    private TextField BuildingProductTextField;
    @FXML
    private TextField ProductPriceTextField;
    @FXML
    private TextField BuildingTitleTextField;
    @FXML
    private Button closeButton;
    @FXML
    private Label WarningLabel;
    @FXML
    private Button payButton;
    @FXML
    private MenuItem Product;
    private String buildingCategory;
    private String productCategory;
    private int constructionPrice;
    private Button buildingButton;

    private ActionEvent buildingButtonEventRefrence;

    private Area area;


    public void EatableProductAction(ActionEvent event){
        productCategory = "Eatable";

    }

    public void ClothingProductAction(ActionEvent event){
        productCategory = "Clothing";
    }

    public void IndustrialProductAction(ActionEvent event){
        productCategory = "Industrial";
    }

    public void BuildingCompanyAction(ActionEvent event){
        buildingCategory = "Company";
        constructionPrice = 100;
    }

    public void BuildingShopAction(ActionEvent event){
        buildingCategory = "Shop";
        constructionPrice = 100;
    }

    public void BuildingEntertainmentCenterAction(ActionEvent event){
        buildingCategory = "EntertainmentCenter";
        constructionPrice = 100;
    }





    public void CloseButtonAction(ActionEvent event){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    int twoLevelComfirm = 1 ;
    public void PayButtonAction(ActionEvent event) throws IOException, SQLException {
        Character character = DashBoard.Currentcharacter;
        if (twoLevelComfirm == 1){
            WarningLabel.setText("The Price Of This Build Will Be " + constructionPrice);
            payButton.setText("Pay");
            twoLevelComfirm++;
        }else {
            if (constructionPrice <= character.getMoney()){
                character.setMoney(character.getMoney() - constructionPrice);
                DataBaseOperations.Update("character" , "money" , character.getMoney() ,character.getID());

                if (buildingCategory.equals("Company") ){
                    System.out.println("giiiiiiiiii");
                    DataBaseOperations.Update( "area" , "Category" , productCategory + "Company" , area.getID());
                    DataBaseOperations.Update( "area" , "Name" ,  BuildingTitleTextField.getText() , area.getID());

                    System.out.println(buildingButton.getId());
                    //buildingButton.setText(BuildingTitleTextField.getText());
                    //buildingButton.setStyle("-fx-background-color: #1c6e75; ");

                    int price = Integer.parseInt(ProductPriceTextField.getText());
                    int productPrice = Integer.parseInt(ProductPriceTextField.getText());
                    Company company = new Company("Recruitmentaion" , area.getID(), false , BuildingTitleTextField.getText(), productCategory + "Company",
                            BuildingProductTextField.getText(), 0 , productPrice  , area.getOwnerID(), 1000 );
                    City.currentCompany = company;
                    DataBaseOperations.InsertCompany(company , Game.CityConnection);


                } else if (buildingCategory == "Shop"){
                    DataBaseOperations.Update( "area" , "Category" , "Shop" , area.getID());
                    DataBaseOperations.Update( "area" , "Name" ,  BuildingTitleTextField.getText() , area.getID());

                    System.out.println(buildingButton.getId());
                    //buildingButton.setText(BuildingTitleTextField.getText());
                    //buildingButton.setStyle("-fx-background-color: #1c6e75; ");

                    int price = Integer.parseInt(ProductPriceTextField.getText());
                    //Company company = new Company("recruit" , area.getID(), false , BuildingTitleTextField.getText(), "Description goes here",
                    //        BuildingProductTextField.getText(), price , 0 , area.getOwnerID(), 1000 );
                   // DataBaseOperations.InsertCompany(company , Game.CityConnection);


                } else if (buildingCategory == "EntertainmentCenter"){
                    DataBaseOperations.Update( "area" , "Category" , "EntertainmentCenter" , area.getID());
                    DataBaseOperations.Update( "area" , "Name" ,  BuildingTitleTextField.getText() , area.getID());

                    System.out.println(buildingButton.getId());
                    //buildingButton.setText(BuildingTitleTextField.getText());
                    //buildingButton.setStyle("-fx-background-color: #1c6e75; ");

                    int price = Integer.parseInt(ProductPriceTextField.getText());
                   // Company company = new Company("recruit" , area.getID(), false , BuildingTitleTextField.getText(), "Description goes here",
                   //         BuildingProductTextField.getText(), price , 0 , area.getOwnerID(), 1000 );
                   // DataBaseOperations.InsertCompany(company , Game.CityConnection);


                }

                DataBaseOperations.IndustrialCompaniesIncomeUpdate(constructionPrice);


            }else{
                WarningLabel.setText("You Dont Have Enough Money");
            }
            SceneOperators.SwitchSceneAction("cityGUIv3.fxml",true);
        }

        //CityBuildingSelectionController.cityBarUpdate();
    }

    public void setBuildingButtonEventRefrence(ActionEvent buildingButtonEventRefrence) {
        this.buildingButtonEventRefrence = buildingButtonEventRefrence;
        buildingButton = (Button)buildingButtonEventRefrence.getSource();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        area = CityBuildingSelectionController.CurrentArea;

    }
}
