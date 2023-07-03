package com.example.lightcityfloat;

import javafx.scene.control.Button;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Game {
	City city ;

	public static Connection CityConnection;
	public static String CityName;
	static Button Building1;
	public static void buildCity(String cityName  ) {
		System.out.println("entered Builder");
		CityName = cityName;
		Connection connection = DataBaseConnection.MakeConnection(cityName, "root" , "13831383" , "jdbc:mysql://localhost/");
		try{
			Statement stmt = connection.createStatement();
			String createCity = "CREATE DATABASE " + cityName;
			stmt.executeUpdate(createCity);
			System.out.println("City Was Built Successfully...");
			System.out.println("Creating Character Table Started");
			String createTableCharacter = "CREATE TABLE `" +cityName+"`.`character` (\n" +
					"  `Job` VARCHAR(40) NULL DEFAULT 'No Job',\n" +
					"  `ID` INT NULL,\n" +
					"  `Status` VARCHAR(45) NULL,\n" +
					"  `Username` VARCHAR(45) NOT NULL,\n" +
					"  `Water` INT NULL DEFAULT 24,\n" +
					"  `Food` INT NULL DEFAULT 64,\n" +
					"  `Sleep` INT NULL DEFAULT 16,\n" +
					"  `MentalHealth` INT NULL DEFAULT 24,\n" +
					"  `Message` VARCHAR(400) NULL DEFAULT 'No Message',\n" +
					"  `WorkPlaceID` VARCHAR(45) NULL,\n" +
					"  `AreasOwnedID` VARCHAR(550) NULL,\n" +
					"  `money` INT NULL,\n" +
					"  PRIMARY KEY (`Username`));";
			System.out.println("Parameters Given");
			stmt.executeUpdate(createTableCharacter);
			System.out.println("Table Was Added Seccuessfully");

			System.out.println("Creating company table ");
			String createTableCompany = "CREATE TABLE `"+cityName+"`.`company` ("+
					"`ID` VARCHAR(45) NOT NULL," +
					"`Name` VARCHAR(45) NULL," +
					"`Description` VARCHAR(400) NULL," +
					"`Product` VARCHAR(45) NULL," +
					"`ProductPrice` INT NULL," +
					"`Price` INT NULL," +
					"`Income` INT NULL," +
					"`Status` VARCHAR(45) NULL," +
					"`OwnerID` INT NULL," +
					"`ForSale` TINYINT NULL DEFAULT '0',"+
					"`CompanyPrice` INT NULL,"+
					"  PRIMARY KEY (`ID`));";


			System.out.println("parameters given ");
			stmt.executeUpdate(createTableCompany);
			System.out.println("Table Company Seccuessfully made");

			System.out.println("Creating Shop table ");
			String createTableShop="CREATE TABLE `"+ cityName +"`.`shop` (" +
					"  `ID` VARCHAR(45) NOT NULL," +
					"`Name` VARCHAR(45) NULL," +
					"`Description` VARCHAR(400) NULL," +
					"  `Status` VARCHAR(45) NULL," +
					"  `SellingProduct` VARCHAR(45) NULL," +
					"  `OwnerID` INT NULL," +
					"  `Income` INT NULL," +
					"`ForSale` TINYINT NULL DEFAULT '0 ',"+
					"`ShopPrice` INT NULL ," +
					"  PRIMARY KEY (`ID`));";
			System.out.println("parameters given ");
			stmt.executeUpdate(createTableShop);
			System.out.println("Table Shop Seccuessfully made");

			System.out.println("Creating Shop table ");
			String createTableٍEntertainmentCenters = "CREATE TABLE `"+ cityName +"`.`entertainmentcenter` (\n" +
					"  `ID` VARCHAR(45) NOT NULL," +
					"`Name` VARCHAR(45) NULL," +
					"`Description` VARCHAR(400) NULL," +
					"  `Status` VARCHAR(45) NULL," +
					"  `Price` INT NULL," +
					"`ForSale` TINYINT NULL DEFAULT '0 ',"+
					"`EntertainmentCenterPrice` INT NULL, " +
					"  PRIMARY KEY (`ID`));";

			System.out.println("parameters given ");
			stmt.executeUpdate(createTableٍEntertainmentCenters);
			System.out.println("Table Entertainment Center Seccuessfully made");

			System.out.println("Creating Bank table ");

			String createTableBank="CREATE TABLE `"+ cityName +"`.`bank` (" +
					"  `PayerID` INT NULL," +
					"  `ReciverID` INT NULL," +
					"  `AmountOfMoney` INT NULL," +
					"  `PaymentID` INT NOT NULL," +
					"  PRIMARY KEY (`PaymentID`));";


			System.out.println("parameters given ");
			stmt.executeUpdate(createTableBank);
			System.out.println("Table Bank Seccuessfully made");



			String createPrisonTable = "CREATE TABLE `" + cityName +"`.`prison` (" +
					"  `ID` VARCHAR(45) NOT NULL," +
					"  `Status` VARCHAR(45) NULL," +
					"  `PrisonerID` INT NOT NULL," +
					"  `DaysLeft` INT NULL DEFAULT 15," +
					"  PRIMARY KEY (`PrisonerID` , `ID`));";


			System.out.println("parameters given ");
			stmt.executeUpdate(createPrisonTable);
			System.out.println("Table Prison Seccuessfully made");

			String createPoliceOfficeTable = "CREATE TABLE `"+ cityName +"`.`policeoffice` (" +
					"  `ID` VARCHAR(45) NOT NULL," +
					"  `Status` VARCHAR(45) NULL," +
					"  `OfficerID` INT NULL," +
					"  `SuspectID` INT NULL," +
					"  `IsCrimeProven` TINYINT NULL,"+
					"  PRIMARY KEY (`ID`));";
			System.out.println("parameters given ");
			stmt.executeUpdate(createPoliceOfficeTable);
			System.out.println("Table Police Office Seccuessfully made");


			String createMuniciPalityTable = "CREATE TABLE `"+ cityName +"`.`municipolity` (" +
					"  `ID` VARCHAR(45) NOT NULL," +
					"  `Status` VARCHAR(45) NULL," +
					"  `MayorID` INT NULL," +
					"  PRIMARY KEY (`ID`));";

			System.out.println("parameters given ");
			stmt.executeUpdate(createMuniciPalityTable);
			System.out.println("Table Municipolity Seccuessfully made");

			String createArea = "CREATE TABLE `"+ cityName +"`.`area` ("+
					"`ID` VARCHAR(45) NOT NULL," +
					"`Status` VARCHAR(45) NULL," +
					"`Category` VARCHAR(45) NULL," +
					"`ForSale` TINYINT NULL DEFAULT '1',"+
					"`areaPrice` INT NULL, " +
					"`OwnerID` INT NULL," +
					"`Name` VARCHAR(45) NULL," +
					" PRIMARY KEY (`ID`));";

			System.out.println("parameters given ");
			stmt.executeUpdate(createArea);
			System.out.println("Table area Seccuessfully made");

			System.out.println("done");
			System.out.println(cityName);
			Area[] building = new Area[40];
			String newurl = "jdbc:mysql://localhost/" + cityName;
			System.out.println(newurl);
			connection = DataBaseConnection.MakeConnection(cityName, "root" , "13831383" , newurl);
			CityConnection = connection;
			DataBaseOperations.CityConnection = connection;
			for (int i = 0; i < 41; i++) {
				String sql = "INSERT INTO Area VALUES (?,?,?,?,?,?,?) ";
				PreparedStatement preparedStatement =  connection.prepareStatement(sql);
				if(i == 21){
					preparedStatement.setString(1,"PoliceOffice");
				}else if(i == 23){
					preparedStatement.setString(1,"Prison");
				}
				else if(i == 40){
					preparedStatement.setString(1,"Bank");
				}
				else if(i == 35){
					preparedStatement.setString(1,"Municipality");
				}
				else{
					preparedStatement.setString(1,"Building"+(i+1));
				}
				preparedStatement.setString(2, "forsale");
				preparedStatement.setString(3, "empty area");
				preparedStatement.setBoolean(4, true);
				preparedStatement.setInt(5, 100);
				preparedStatement.setInt(6,1);
				preparedStatement.setString(7,"empty area");
				preparedStatement.executeUpdate();

			}
			System.out.println(connection.getSchema());
			String job = "mayor" ;
			int ID = 1 ;
			String status = "alive";
			String Username = Login.Username;
			int water = 100 ;
			int food = 100 ;
			int sleep = 100;
			int mentalHealth = 100;
			String message = null;
			String workPlaceID = "Municipality";
			ArrayList<Area> areasOwned = new ArrayList<>();

			for (int i = 1 ; i <= 40 ; i++) {

				if(i == 22){
					areasOwned.add(ConvertFXMLtoOBJ.ButtonToBuilding("PoliceOffice"));
				}else if(i == 24){
					areasOwned.add(ConvertFXMLtoOBJ.ButtonToBuilding("Prison"));
				}
				else if(i == 41){
					areasOwned.add(ConvertFXMLtoOBJ.ButtonToBuilding("Bank"));
				}
				else if(i == 36){
					areasOwned.add(ConvertFXMLtoOBJ.ButtonToBuilding("Municipality"));
				}
				else{
					System.out.println("Building"+i);
					areasOwned.add(ConvertFXMLtoOBJ.ButtonToBuilding("Building"+i));
				}

				System.out.println("gi");
			}
			int money = ThreadLocalRandom.current().nextInt(10,100000);
			float health = 100 ;


			//	String sql = "INSERT INTO character (`Job`, `ID`, `Status`, `Username`, `Water`, `Food`, `Sleep`, `MentalHealth`, `WorkPlaceID`, `money`) VALUES ('mayor', '1', 'alive', 'mmd', '100', '100', '100', '100', 'manicipality', '10000')";
				//PreparedStatement preparedStatement = connection.prepareStatement(sql);
			//	preparedStatement.executeUpdate();
				Character character = new Character(job ,ID,status,Username,water,food,sleep,mentalHealth,message,workPlaceID,areasOwned,money,health);
				DataBaseOperations.InsertCharacter(character,connection);
				System.out.println("bruh");
				System.out.println(character.getID());
				City.mayor = character;
				DashBoard.Character(character);



		}
		catch (Exception e){
			e.printStackTrace();
		}




	}
	
	public static void startGame() {
		
	}

	public static void Join(String url , String username){
		Connection connection = DataBaseConnection.JoinConnection(url);
		CityConnection = connection;
		DataBaseOperations.CityConnection = connection;
		 String job = "no_job" ;
		 int ID = ThreadLocalRandom.current().nextInt(10000000,99999999);
		 String status = "alive";
		 String Username = username;
		 int water = 100 ;
		 int food = 100 ;
		 int sleep = 100;
		 int mentalHealth = 100;
		 String message = null;
		 String workPlaceID = "no_ID";
		 ArrayList<Area> areasOwned = new ArrayList<>() ;
		 int money = ThreadLocalRandom.current().nextInt(10,100000);
		 float health = 100 ;


		try {

			Character character = new Character(job ,ID,status,Username,water,food,sleep,mentalHealth,message,workPlaceID,areasOwned,money,health);
			 if(DataBaseOperations.InsertCharacter(character,connection)){
				 DashBoard.Character(character);
			 }
			 else {
				 System.out.println("You Have Already Joined This Server");
			 }

		}
		catch (Exception e){
			e.printStackTrace();
		}
	}

	public static void Continue(String url , String username){
		Connection connection = DataBaseConnection.JoinConnection(url);
		CityConnection = connection;
		DataBaseOperations.CityConnection = connection;

		Character character = DataBaseOperations.Extract_Character(Login.Username);
		try{
			System.out.println(character.getUsername());
			if (character != null){
				if (character.getID()==1){
					City.mayor = character;
				}
				DashBoard.Character(character);
			} else if(character.getStatus().equals("Dead")){

			}
			else {
				System.out.println("No User Found");
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}

	}
}
