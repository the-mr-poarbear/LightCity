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
        Character OtherCharacter = null;
        System.out.println(transaction.getReciverID());
        System.out.println(transaction.getPayerID());
        if(character.getID() == transaction.getPayerID()){
            OtherCharacter = DataBaseOperations.Extract_CharacterWithID(transaction.getReciverID());
            character.setMoney(character.getMoney() - transaction.getAmountOfMoney());
            OtherCharacter.setMoney(OtherCharacter.getMoney() + transaction.getAmountOfMoney());
            System.out.println("Money Bye Bye");

        }else if(character.getID() == transaction.getReciverID()){
            OtherCharacter = DataBaseOperations.Extract_CharacterWithID(transaction.getPayerID());
            character.setMoney(character.getMoney() + transaction.getAmountOfMoney());
            OtherCharacter.setMoney(OtherCharacter.getMoney() - transaction.getAmountOfMoney());
            System.out.println("Money Hello ");
        }
        DataBaseOperations.Update("character" , "money" , character.getMoney() , character.getID());
        DataBaseOperations.Update("character" , "money" , OtherCharacter.getMoney() , OtherCharacter.getID());
        DataBaseOperations.Delete("bank" , transaction.getTransactionID());
        DataBaseOperations.transactions.remove(transaction);

        System.out.println(DataBaseOperations.transactions);
        //Character identifier = DataBaseOperations.Extract_Character(character.);
        //dont forget tpo delete the transaction from bank afterproccess is done
    }
}
