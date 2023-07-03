package com.example.lightcityfloat.ControllerClasses;

import com.example.lightcityfloat.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class SceneOperators {

    static FXMLLoader fxmlLoaderr;
    public static FXMLLoader SwitchSceneAction( String sceneFXML , boolean isMainStage) throws IOException {
        Stage stage;
        if (isMainStage){
            stage = Main.stagee;
        } else {
            stage =  new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
        }
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(sceneFXML));
        Scene scene = new Scene(fxmlLoader.load());
        fxmlLoaderr = fxmlLoader;
        stage.setScene(scene);
        stage.show();

        return fxmlLoader;
    }


}
