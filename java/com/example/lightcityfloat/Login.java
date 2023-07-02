package com.example.lightcityfloat;

import com.example.lightcityfloat.ControllerClasses.SceneOperators;

import java.sql.*;

public class Login {

    public static String Username ;

    static Connection connection = DataBaseConnection.MakeConnection("sql8629458" , "sql8629458","tEVVZQxpJw" ,"jdbc:mysql://sql8.freesqldatabase.com/sql8629458");
    public static void Player(String username , String password){


//        String verifyLogin = "SELECT count(1) FROM Login WHERE Username = '" + username + "' AND Password = '" + password + "'";
        String verifyLogin = "SELECT Password FROM Login WHERE Username = ? ";
        try{
//            Statement statement = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement(verifyLogin);
            preparedStatement.setString(1,username  );
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();

            if(Encryption.decrypt(resultSet.getString(1)).equals(password)){
                System.out.println("Dashbored");
               Username = username;
               SceneOperators.SwitchSceneAction("preGameMenu.fxml" , true);
            }
            else {
                System.out.println("wrong password");
            }
        }
        catch (SQLException e) {
            System.out.println("player not found");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void registery(String username , String password){

        // boolean Check = true;
        // while ()

        String sql = "INSERT INTO Login VALUES (?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, Encryption.encrypt(password) );
            preparedStatement.executeUpdate();

            System.out.println("Dashbored");
            Username = username;
            SceneOperators.SwitchSceneAction("preGameMenu.fxml" , true);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
