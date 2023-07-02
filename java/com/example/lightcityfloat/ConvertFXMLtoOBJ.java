package com.example.lightcityfloat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConvertFXMLtoOBJ {

   public static Area ButtonToBuilding(String ID){
       Connection connection = Game.CityConnection;
       String findBuilding = "SELECT * FROM area WHERE ID = ? ";
       try {
           PreparedStatement preparedStatement = connection.prepareStatement(findBuilding);
           preparedStatement.setString(1, ID);
           ResultSet resultSet = preparedStatement.executeQuery();
           resultSet.next();
           String status = resultSet.getString(2);
           String category = resultSet.getString(3);
           boolean forSale = resultSet.getBoolean(4);
           int price = resultSet.getInt(5);
           int ownerID = resultSet.getInt(6);
           String name = resultSet.getString(7);

           Area area = new Area(ID, status,  forSale,  category , price , ownerID , name);
           System.out.println(area);
          return area;
       }
       catch (Exception e){
           e.printStackTrace();
           return null;
       }
   }



    public static Company ButtonToCompany(String ID){
        Connection connection = Game.CityConnection;
        String findBuilding = "SELECT * FROM company WHERE ID = ? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(findBuilding);
            preparedStatement.setString(1, ID);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            String Name = resultSet.getString(2);
            String Description = resultSet.getString(3);
            String Product = resultSet.getString(4);
            int ProductPrice = resultSet.getInt(5);
            int Price = resultSet.getInt(6);
            int Income = resultSet.getInt(7);
            String Status = resultSet.getString(8);
            int ownerID = resultSet.getInt(9);
            boolean ForSale = resultSet.getBoolean(10);
            int CompanyPrice = resultSet.getInt(11);

           Company company = new Company(Status, ID,  ForSale,  Name , Description , Product , Income , ProductPrice , ownerID , CompanyPrice);
            System.out.println(company);
            return company;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
