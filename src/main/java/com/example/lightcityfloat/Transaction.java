package com.example.lightcityfloat;

public class Transaction {
    int payerID ;
    int reciverID ;
    int transactionID ;

    int amountOfMoney ;

    Character character = DashBoard.Currentcharacter;

    public Transaction(int payerID, int reciverID, int amountOfMoney, int transactionID) {
        this.payerID = payerID;
        this.reciverID = reciverID;
        this.transactionID = transactionID;
        this.amountOfMoney = amountOfMoney;
    }


    public int getPayerID() {
        return payerID;
    }

    public int getReciverID() {
        return reciverID;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public int getAmountOfMoney() {
        return amountOfMoney;
    }

    public String toString(){
        if(character.getID() == payerID){
            return  "\nPay To : " + reciverID + "\n" +
                    "Amount : " + amountOfMoney + "$"+ "\n" +
                    "ID : " + transactionID + "\n" +
                    "_________________________________";
        }else if( character.getID() == reciverID) {
            return  "\nReceive From : " + payerID + "\n" +
                    "Amount : " + amountOfMoney + "$"+ "\n" +
                    "ID : " + transactionID + "\n" +
                    "_________________________________";
        } else{
            return  "\nReceiver : " + reciverID + "\n" +
                    "Payer : " + payerID + "\n" +
                    "Amount : " + amountOfMoney + "$"+ "\n" +
                    "ID : " + transactionID + "\n" +
                     "_________________________________";

        }
    }
}
