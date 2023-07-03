package com.example.lightcityfloat;
import java.sql.*;

public class DataBaseConnection {
    public static Connection connection;

    public static Connection MakeConnection(String databaseName , String username , String password , String url ){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url , username , password);

        }
        catch (Exception e){
            e.printStackTrace();
        }

        return connection;
    }

    public static Connection JoinConnection(String url){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url , "root" , "13831383");
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return connection;
    }
}
