package com.example.lightcityfloat.ControllerClasses;

import com.example.lightcityfloat.Character;
import com.example.lightcityfloat.DashBoard;
import com.example.lightcityfloat.DataBaseOperations;
import com.example.lightcityfloat.Transaction;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class BankController {

    @FXML
    private Label transactionsLabel ;
    @FXML
    private TextField transactionIDTextField;
    @FXML
    private Button cancelButton;

    Character character = DashBoard.Currentcharacter;

    public void BankInfoController(ActionEvent event , int ID){
        System.out.println("s");
        DataBaseOperations.TransactionsFiltered(ID);
        System.out.println("l");
        ArrayList<Transaction> transactions = DataBaseOperations.transactions;

        transactionsLabel.setText(transactions.toString());
    }

    public void CancelButtonAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
        SceneOperators.SwitchSceneAction("cityGUIv3.fxml",true);
    }

    public void ConfirmButtonAction(ActionEvent event) {
        int transactionID = Integer.parseInt(transactionIDTextField.getText());
        Transaction transaction = DataBaseOperations.Extract_Transactions(transactionID);
        
        //Character identifier = DataBaseOperations.Extract_Character(character.);
        //dont forget tpo delete the transaction from bank afterproccess is done
    }
}
