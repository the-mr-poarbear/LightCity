package com.example.lightcityfloat;

import java.sql.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class DataBaseOperations {
    public static Connection CityConnection;
    public static Character character = DashBoard.Currentcharacter;

    public static void SetConnection(Connection connection){
        CityConnection = connection;
    }

    public static ArrayList<Transaction> transactions = new ArrayList<Transaction>();

    public static boolean InsertCharacter(Character character , Connection connection){

        String AreasID = Character.AreasToID(character.getAreasOwned());

        System.out.println(AreasID);
        try {
            System.out.println(connection.getSchema());
            String createNewCharacter = "INSERT INTO `character` VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(createNewCharacter);

            preparedStatement.setString(1 ,character.getJob());
            preparedStatement.setInt(2,character.getID());
            preparedStatement.setString(3,character.getStatus());
            preparedStatement.setString(4,character.getUsername());
            preparedStatement.setInt(5,character.getWater());
            preparedStatement.setInt(6,character.getFood());
            preparedStatement.setInt(7,character.getSleep());
            preparedStatement.setInt(8,character.getMentalHealth());
            preparedStatement.setString(9,character.getMessage());
            preparedStatement.setString(10,character.getWorkPlaceID());
            preparedStatement.setString(11, AreasID);
            preparedStatement.setInt(12,character.getMoney());

            preparedStatement.executeUpdate();
            return true;
        }
        catch (SQLIntegrityConstraintViolationException e){
            return false;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }


    public static boolean InsertCompany(Company company , Connection connection){

        try {
            System.out.println(connection.getSchema());
            String createNewCompany = "INSERT INTO `company` VALUES (?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(createNewCompany);

            preparedStatement.setString(1 ,company.getID());
            preparedStatement.setString(2,company.getName());
            preparedStatement.setString(3,company.getCategory());
            preparedStatement.setString(4,company.getProduct());
            preparedStatement.setInt(5,company.getProductPrice());
            preparedStatement.setInt(6,company.getPrice());
            preparedStatement.setInt(7,company.getIncome());
            preparedStatement.setString(8,company.getStatus());
            preparedStatement.setInt(9,company.getOwnerID());
            preparedStatement.setBoolean(10, company.isForSale());
            preparedStatement.setInt(11,company.getCompanyPrice());

            preparedStatement.executeUpdate();
            return true;
        }
        catch (SQLIntegrityConstraintViolationException e){
            return false;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }




    public static Character Extract_Character(String Username){
        String Job=null;
        int ID = 0;
        String Status =null;
        int water =0;
        int food =0;
        int sleep =0;
        int mentalHealth = 100 ;
        String message = null ;
        String workPlaceID = null;
        String AreasOwnedID = null;
        int Money =0;

        String sql = "SELECT * FROM `character` WHERE Username=?";

        try {
            PreparedStatement preparedStatement = CityConnection.prepareStatement(sql);
            System.out.println(CityConnection);
            preparedStatement.setString(1, Username);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            Job = resultSet.getString(1);
            ID  = resultSet.getInt(2);
            Status = resultSet.getString(3);
            Username = resultSet.getString(4);
            water = resultSet.getInt(5);
            food = resultSet.getInt(6);
            sleep = resultSet.getInt(7);
            mentalHealth = resultSet.getInt(8);
            message = resultSet.getString(9);
            workPlaceID = resultSet.getString(10);
            AreasOwnedID = resultSet.getString(11);
            Money = resultSet.getInt(12);

        }
        catch (Exception e) {
            e.printStackTrace();
        }


        String[] AreasOwnedIDArray = AreasOwnedID.split(",");
        ArrayList<Area> AreasOwned = new ArrayList();
        for (String areaID: AreasOwnedIDArray) {
            AreasOwned.add(DataBaseOperations.Extract_Area(areaID));
        }

        int health = (water + sleep + food)/3 ;


        return new Character(Job , ID , Status , Username ,water,food,sleep,mentalHealth,message,workPlaceID,AreasOwned,Money , health );
    }

    public static Character Extract_CharacterWithID(int ID){
        System.out.println("GI" + ID);
        String Job=null;
        String Username = null;
        String Status =null;
        int water =0;
        int food =0;
        int sleep =0;
        int mentalHealth = 100 ;
        String message = null ;
        String workPlaceID = null;
        String AreasOwnedID = null;
        int Money =0;

        String sql = "SELECT * FROM `character` WHERE ID=?";

        try {
            System.out.println("h");
            PreparedStatement preparedStatement = CityConnection.prepareStatement(sql);
            System.out.println(CityConnection);
            preparedStatement.setInt(1, ID);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            Job = resultSet.getString(1);
            ID  = resultSet.getInt(2);
            Status = resultSet.getString(3);
            Username = resultSet.getString(4);
            water = resultSet.getInt(5);
            food = resultSet.getInt(6);
            sleep = resultSet.getInt(7);
            mentalHealth = resultSet.getInt(8);
            message = resultSet.getString(9);
            workPlaceID = resultSet.getString(10);
            AreasOwnedID = resultSet.getString(11);
            Money = resultSet.getInt(12);

        }
        catch (Exception e) {
            e.printStackTrace();
        }


        String[] AreasOwnedIDArray = AreasOwnedID.split(",");
        ArrayList<Area> AreasOwned = new ArrayList();
        for (String areaID: AreasOwnedIDArray) {
            AreasOwned.add(DataBaseOperations.Extract_Area(areaID));
        }

        int health = (water + sleep + food)/3 ;


        return new Character(Job , ID , Status , Username ,water,food,sleep,mentalHealth,message,workPlaceID,AreasOwned,Money , health );
    }


    public static void BankTransaction(int payerID , int receiverID , int transactionAmount){
        try{
            String createNewCharacter = "INSERT INTO `bank` VALUES (?,?,?,?)";
            int transactionID = ThreadLocalRandom.current().nextInt(10000000,99999999);
            PreparedStatement preparedStatement = CityConnection.prepareStatement(createNewCharacter);

            preparedStatement.setInt(1 ,payerID);
            preparedStatement.setInt(2,receiverID);
            preparedStatement.setInt(3,transactionAmount);
            preparedStatement.setInt(4,transactionID);
            preparedStatement.executeUpdate();
        }
        catch (Exception e){

        }
    }


    public static void Update(String table_name,String updatedParameter,String updatedValue,int ID) {
        try {
            String sql = "UPDATE "+"`"+table_name+"`"+" SET "+updatedParameter+"=? WHERE ID=?";

            PreparedStatement preparedStatement = CityConnection.prepareStatement(sql);
            preparedStatement.setString(1, updatedValue);
            preparedStatement.setInt(2, ID);

            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    static Area Extract_Area(String ID){



        String Status=null;
        String Category=null;
        boolean ForSale = false ;
        int AreaPrice = 0 ;
        int OwnerID = 0;
        String Name = null ;
        String sql = "SELECT * FROM `area` WHERE ID=?";

        try {
            PreparedStatement preparedStatement = CityConnection.prepareStatement(sql);
            preparedStatement.setString(1, ID);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            ID = resultSet.getString(1);
            Status = resultSet.getString(2);
            Category = resultSet.getString(3);
            ForSale = resultSet.getBoolean(4);
            AreaPrice = resultSet.getInt(5);
            OwnerID = resultSet.getInt(6);
            Name =  resultSet.getString(7);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return new Area(ID,Status, ForSale ,Category  , AreaPrice , OwnerID , Name);
    }


    public static void ExtractCityGraphics(){



    }

    public static Transaction Extract_Transactions(int transactionID){

        String sql = "SELECT * FROM bank WHERE `PaymentID` = ? ";

        try {
            PreparedStatement preparedStatement = CityConnection.prepareStatement(sql);
            preparedStatement.setInt(1, transactionID );
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("am");
            resultSet.next();
            int payerID = resultSet.getInt(1);
            int receiverID = resultSet.getInt(2);
            int amountOfMoney = resultSet.getInt(3);
            int TransactionID = resultSet.getInt(4);

            return new Transaction(payerID , receiverID , amountOfMoney , TransactionID );

        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    public static void TransactionsFiltered(int ID ){
        System.out.println("l");
        String sql = "SELECT * FROM bank WHERE PayerID = ? OR ReciverID = ? ";

        try {
            PreparedStatement preparedStatement = CityConnection.prepareStatement(sql);
            preparedStatement.setInt(1, ID );
            preparedStatement.setInt(2, ID );
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("am");
            while(resultSet.next()) {
                int payerID = resultSet.getInt(1);
                int receiverID = resultSet.getInt(2);
                int amountOfMoney = resultSet.getInt(3);
                int transactionID = resultSet.getInt(4);
                Transaction transaction = new Transaction(payerID , receiverID , amountOfMoney , transactionID );
                transactions.add(transaction);
                System.out.println(transaction);

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void IndustrialCompaniesIncomeUpdate(int constructPrice ) {

        try{
            String sql = "SELECT * FROM company WHERE Category = ? " ;
            PreparedStatement preparedStatement = CityConnection.prepareStatement(sql);
            preparedStatement.setString(1, "IndustrialCompany");
            ResultSet resultSet = preparedStatement.executeQuery();
            String companyID = null ;
            int companyIncome = 0 ;
            while (resultSet.next()){
                companyID = resultSet.getString(1);
                companyIncome = resultSet.getInt(7);
                Update("company" , "Income" , companyIncome + constructPrice , companyID);
            }


        }
        catch (Exception e){
            e.printStackTrace();
        }

    }


    public static void Update(String table_name,String updatedParameter,int updatedValue,int ID) {
        try {
            String sql = "UPDATE "+"`"+table_name+"`"+" SET "+updatedParameter+"=? WHERE ID=?";

            PreparedStatement preparedStatement = CityConnection.prepareStatement(sql);
            preparedStatement.setInt(1, updatedValue);
            preparedStatement.setInt(2, ID);

            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void Update(String table_name,String updatedParameter,boolean updatedValue,int ID) {
        try {
            String sql = "UPDATE "+"`"+table_name+"`"+" SET "+updatedParameter+"=? WHERE ID=?";

            PreparedStatement preparedStatement = CityConnection.prepareStatement(sql);
            preparedStatement.setBoolean(1, updatedValue);
            preparedStatement.setInt(2, ID);

            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void Update(String table_name,String updatedParameter,String updatedValue,String ID) {
        try {
            String sql = "UPDATE "+"`"+table_name+"`"+" SET "+updatedParameter+"=? WHERE ID=?";

            PreparedStatement preparedStatement = CityConnection.prepareStatement(sql);
            preparedStatement.setString(1, updatedValue);
            preparedStatement.setString(2, ID);

            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void Update(String table_name,String updatedParameter,int updatedValue,String ID) {
        try {
            String sql = "UPDATE "+"`"+table_name+"`"+" SET "+updatedParameter+"=? WHERE ID=?";

            PreparedStatement preparedStatement = CityConnection.prepareStatement(sql);
            preparedStatement.setInt(1, updatedValue);
            preparedStatement.setString(2, ID);

            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void Update(String table_name,String updatedParameter,boolean updatedValue,String ID) {
        try {
            String sql = "UPDATE "+"`"+table_name+"`"+" SET "+updatedParameter+"=? WHERE ID=?";

            PreparedStatement preparedStatement = CityConnection.prepareStatement(sql);
            preparedStatement.setBoolean(1, updatedValue);
            preparedStatement.setString(2, ID);

            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void Delete(String table_name,int ID) {
        try {
            String sql = null;
            if (table_name.equals("bank")){
                sql = "DELETE FROM "+"`"+table_name+"`"+" WHERE PaymentID=?";
            } else{
                sql = "DELETE FROM "+"`"+table_name+"`"+" WHERE ID=?";
            }


            PreparedStatement preparedStatement = CityConnection.prepareStatement(sql);
            preparedStatement.setInt(1, ID);

            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void Delete(String table_name,String ID) {
        try {
            String sql = "DELETE FROM "+"`"+table_name+"`"+" WHERE ID=?";

            PreparedStatement preparedStatement = CityConnection.prepareStatement(sql);
            preparedStatement.setString(1, ID);

            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void PayEmployees(String workID, int companyIncome) {

        try{
            String sql = "SELECT COUNT(*) FROM `character` WHERE WorkPlaceID = ? ";

            PreparedStatement preparedStatement = CityConnection.prepareStatement(sql);
            preparedStatement.setString(1, workID);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int employeeCount = resultSet.getInt(1);

            int employeeIncome = companyIncome/(2 * employeeCount);
            int ownerIncome = companyIncome/2;
            int characterID = 0;
            int charactermoney = 0;

            String sql2 = "SELECT * FROM `character` WHERE WorkPlaceID = ? ";


            PreparedStatement preparedStatement2 = CityConnection.prepareStatement(sql2);
            preparedStatement2.setString(1, workID);
            ResultSet resultSet2 = preparedStatement2.executeQuery();
            while(resultSet2.next()){

                characterID = resultSet2.getInt(2);
                charactermoney = resultSet2.getInt(12);

                Update("character" , "money" , charactermoney + employeeIncome , characterID);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
