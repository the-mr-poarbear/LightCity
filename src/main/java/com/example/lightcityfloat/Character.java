package com.example.lightcityfloat;

import com.example.lightcityfloat.ControllerClasses.SceneOperators;
import com.example.lightcityfloat.ControllerClasses.YouDiedController;
import javafx.application.Platform;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Character {

	//charater = avatar ;
	private String job ;
	private int ID ;
	private String status;
	private String username;
	private int water ;
	private int food ;
	private int sleep ;
	private int mentalHealth;
	private String message ;
	private String workPlaceID ;
	private ArrayList<Area> areasOwned ;
	private int money;
	private float health ;

	public Character(String job, int ID, String status, String username, int water, int food, int sleep, int mentalHealth, String message, String workPlaceID, ArrayList<Area> areasOwned, int money, float health) {
		this.job = job;
		this.ID = ID;
		this.status = status;
		this.username = username;
		this.water = water;
		this.food = food;
		this.sleep = sleep;
		this.mentalHealth = mentalHealth;
		this.message = message;
		this.workPlaceID = workPlaceID;
		this.areasOwned = areasOwned;
		this.money = money;
		this.health = health;
	}


	public static String AreasToID(ArrayList<Area> areas){
		String AreasID = "" ;

		for (Area area : areas) {

			AreasID += area.getID();
			AreasID += "," ;
		}

		return AreasID;
	}
	public String getJob() {
		return job;
	}

	public int getID() {
		return ID;
	}

	public String getStatus() {
		return status;
	}

	public String getUsername() {
		return username;
	}

	public int getWater() {
		return water;
	}

	public int getFood() {
		return food;
	}

	public int getSleep() {
		return sleep;
	}

	public int getMentalHealth() {
		return mentalHealth;
	}

	public String getMessage() {
		return message;
	}

	public String getWorkPlaceID() {
		return workPlaceID;
	}

	public ArrayList<Area> getAreasOwned() {
		return areasOwned;
	}

	public int getMoney() {
		return money;
	}

	public float getHealth() {
		return health;
	}


	public void setJob(String job) {
		this.job = job;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setWater(int water) {
		this.water = water;
	}

	public void setFood(int food) {
		this.food = food;
	}

	public void setSleep(int sleep) {
		this.sleep = sleep;
	}

	public void setMentalHealth(int mentalHealth) {
		this.mentalHealth = mentalHealth;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setWorkPlaceID(String workPlaceID) {
		this.workPlaceID = workPlaceID;
	}

	public void setAreasOwned(ArrayList<Area> properties) {
		this.areasOwned = areasOwned;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public void setHealth(float health) {
		this.health = health;
	}

	public void SleepReduce(){
		Timer timer = new Timer();
		TimerTask reduceSleep = new TimerTask() {
			boolean done = false ;
			@Override
			public void run() {
				sleep--;

				Platform.runLater(() -> {
					if(sleep <= 0 && !done){
						System.out.println("salam");
						done = true;
						try{
							System.out.println("aleyk");
							YouDiedController.YouDied();
							DataBaseOperations.Update("character" , "Status" ,"Dead" , getID() );
						}
						catch (Exception e){
							e.printStackTrace();
						}
					}
				});

				DataBaseOperations.Update("character" , "Sleep" ,sleep , getID() );

			}
		};

		timer.schedule(reduceSleep , 01 , 1000*60*3);
	}

	public void FoodReduce(){
		Timer timer = new Timer();
		TimerTask reduceFood = new TimerTask() {
			boolean done = false ;
			@Override
			public void run() {
				done = true;
				food--;
				Platform.runLater(() -> {
					if(food <= 0 && !done){
						try{
							DataBaseOperations.Update("character" , "Status" ,"Dead" , getID() );
							YouDiedController.YouDied();
						}
						catch (Exception e){
							e.printStackTrace();
						}
					}
				});


				DataBaseOperations.Update("character" , "Food" ,food , getID() );
			}
		};

		timer.schedule(reduceFood , 01 , 1000*60*4);
	}

	public void WaterReduce(){
		Timer timer = new Timer();
		TimerTask reduceWater = new TimerTask() {
			boolean done = false ;
			@Override
			public void run() {
				done = true;
				water--;
				Platform.runLater(() -> {
					if(water <= 0 && !done){
						done = true ;
						try{
							DataBaseOperations.Update("character" , "Status" ,"Dead" , getID() );
							YouDiedController.YouDied();
						}
						catch (Exception e){
							e.printStackTrace();
						}
					}
				});

				DataBaseOperations.Update("character" , "Water" ,water , getID() );
			}
		};

		timer.schedule(reduceWater, 01 , 1000*60*2);
	}

}


