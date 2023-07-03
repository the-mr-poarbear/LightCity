package com.example.lightcityfloat.ControllerClasses;

import com.example.lightcityfloat.*;
import com.example.lightcityfloat.Character;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class CityBuildingSelectionController implements Initializable {

    @FXML
    private Button closeButton;
    @FXML
    private  Label moneyLabel ;
    @FXML
    private  Label foodLabel;
    @FXML
    private  Label waterLabel;
    @FXML
    private  Label sleepLabel;
    @FXML
    private  Label healthLabel;
    @FXML
    private Label clockLabel;
    @FXML
    private static ImageView cityLayout;

    private ArrayList<Button> bs = new ArrayList<>();

    @FXML
    private Button Building1 ;
    @FXML
    private Button Building2 ;
    @FXML
    private Button Building3 ;
    @FXML
    private Button Building4 ;
    @FXML
    private Button Building5 ;
    @FXML
    private Button Building6 ;
    @FXML
    private Button Building7;
    @FXML
    private Button Building8;
    @FXML
    private Button Building9;
    @FXML
    private Button Building10;
    @FXML
    private Button Building11;
    @FXML
    private Button Building12;
    @FXML
    private Button Building13;
    @FXML
    private Button Building14;
    @FXML
    private Button Building15 ;
    @FXML
    private Button Building16 ;
    @FXML
    private Button Building17 ;
    @FXML
    private Button Building18 ;
    @FXML
    private Button Building19 ;
    @FXML
    private Button Building20 ;
    @FXML
    private Button Building21 ;
    @FXML
    private Button PoliceOffice ;
    @FXML
    private Button Building23 ;
    @FXML
    private Button Prison ;
    @FXML
    private Button Building25 ;
    @FXML
    private Button Building26 ;
    @FXML
    private Button Building27 ;
    @FXML
    private Button Building28 ;
    @FXML
    private Button Building29 ;
    @FXML
    private Button Building30 ;
    @FXML
    private Button Building31 ;
    @FXML
    private Button Building32 ;
    @FXML
    private Button Building33 ;
    @FXML
    private Button Building34 ;
    @FXML
    private Button Building35 ;
    @FXML
    private Button Municipality ;
    @FXML
    private Button Building37 ;
    @FXML
    private Button Building38 ;
    @FXML
    private Button Building39 ;
    @FXML
    private Button Building40 ;
    @FXML
    private Button Bank ;







    static Character character = DashBoard.Currentcharacter;
    public static Area CurrentArea;
    public static Button CurrentButton ;
    public void BuildingSelectedAction(ActionEvent event) throws IOException {
        System.out.println("Building Number " +  ((Button)event. getSource()).getId() + " Was Selected  " );
        CurrentButton = (Button)event. getSource();

        Area area = ConvertFXMLtoOBJ.ButtonToBuilding(((Button)event. getSource()).getId());

        if(area.getCategory().equals("empty area")){
            CurrentArea = area;
            try{

            /*FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("BuildingInfoWindow.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage =  new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.show();*/
                if(area.getID().equals("Municipality")){
                    System.out.println("1");
                } else  if(area.getID().equals("PoliceOffice")){

                } else  if(area.getID().equals("Prison")){
                    System.out.println("3");
                } else  if(area.getID().equals("Bank")){
                    System.out.println("3");
                    BankController b = SceneOperators.SwitchSceneAction("BankWindow.fxml" , false).getController();
                    b.BankInfoController(event , character.getID());
                } else{
                    BuildingInfoController b = SceneOperators.SwitchSceneAction("BuildingInfoWindow.fxml" , false).getController();
                    b.BuildingInfoWindowAction(event);
                }


                // if(!area.isForSale()){
                //     buyButtonBuilding.setDisable(true);
                //  }

            }
            catch (Exception e){
                e.printStackTrace();
            }

        } else if(area.getCategory().equals("IndustrialCompany") || area.getCategory().equals("EatableCompany") || area.getCategory().equals("ClothingCompany")){

            CompanyInfoController c = SceneOperators.SwitchSceneAction("CompanyInfoWindow.fxml" , false).getController();
            c.CompanyInfoWindowAction(event);
        }

    }


    //Exit
    public void CloseButtonAction(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public void AddToArraylist(){
        bs.add(Building1);
        bs.add(Building2);
        bs.add(Building3);
        bs.add(Building4);
        bs.add(Building5);
        bs.add(Building6);
        bs.add(Building7);
        bs.add(Building8);
        bs.add(Building9);
        bs.add(Building10);
        bs.add(Building11);
        bs.add(Building12);
        bs.add(Building13);
        bs.add(Building14);
        bs.add(Building15);
        bs.add(Building16);
        bs.add(Building17);
        bs.add(Building18);
        bs.add(Building19);
        bs.add(Building20);
        bs.add(Building21);
        bs.add(PoliceOffice);
        bs.add(Building23);
        bs.add(Prison);
        bs.add(Building25);
        bs.add(Building26);
        bs.add(Building27);
        bs.add(Building28);
        bs.add(Building29);
        bs.add(Building30);
        bs.add(Building31);
        bs.add(Building32);
        bs.add(Building33);
        bs.add(Building34);
        bs.add(Building35);
        bs.add(Municipality);
        bs.add(Building37);
        bs.add(Building38);
        bs.add(Building39);
        bs.add(Building40);
        bs.add(Bank);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        character = DashBoard.Currentcharacter;
        System.out.println(DashBoard.Currentcharacter);
        moneyLabel.setText(String.valueOf(DashBoard.Currentcharacter.getMoney()));
        foodLabel.setText(String.valueOf(DashBoard.Currentcharacter.getFood()));
        waterLabel.setText(String.valueOf(DashBoard.Currentcharacter.getWater()));
        sleepLabel.setText(String.valueOf(DashBoard.Currentcharacter.getSleep()));
        healthLabel.setText(String.valueOf(DashBoard.Currentcharacter.getHealth()));
        clockLabel.setText(String.valueOf(Time.GameTime()));
        AddToArraylist();

        for (Button b : bs) {
            System.out.println("giiii");
            Area area = ConvertFXMLtoOBJ.ButtonToBuilding(b.getId());
            String name = Objects.requireNonNull(area.getName());
            b.setText(name);
            if(area.getCategory().equals("IndustrialCompany") || area.getCategory().equals("EatableCompany") || area.getCategory().equals("ClothingCompany")){
                b.setStyle("-fx-background-color: #1c6e75; ");
            } else  if(area.getCategory().equals("Shop")){
                b.setStyle("-fx-background-color: #e3cf17; ");
            } else if(area.getCategory().equals("EntertainmentCenter")){
                b.setStyle("-fx-background-color: #590678; ");
            } else if(area.getID().equals("Bank")){
                b.setText("Bank");
            }else if(area.getID().equals("Prison")){
                b.setText("Prison");
            }else if(area.getID().equals("PoliceOffice")){
                b.setText("PoliceOffice");
            }else if(area.getID().equals("Municipality")){
                b.setText("Municipality");
            }
        }
    }

}
