package com.example.lightcityfloat;

import com.example.lightcityfloat.ControllerClasses.SceneOperators;
import javafx.scene.control.Button;

import java.io.IOException;

public class DashBoard {

    public static Character Currentcharacter;
    public static void Character(Character character) throws IOException {
        character.FoodReduce();
        character.SleepReduce();
        character.WaterReduce();
        Currentcharacter = character;

        SceneOperators.SwitchSceneAction("cityGUIv3.fxml" , true);
        //DataBaseOperations.RnderCityGraphics();

    }

   /* public String BuyBuilding(Area area){
        if (area.isForSale() && area.getPrice() <= Currentcharacter.getMoney()){
            area.setOwnerID(Currentcharacter.getID());
            Currentcharacter.setMoney(Currentcharacter.getMoney()-area.getPrice());
            area.setForSale(false);

            return ""

        } else if (!area.isForSale()) {
           return "This Place Is Not For Sale";
        }
    }*/
}
