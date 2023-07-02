package com.example.lightcityfloat;

import java.util.ArrayList; 

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
}
