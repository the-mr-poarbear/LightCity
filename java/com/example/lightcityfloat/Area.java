package com.example.lightcityfloat;

public class Area {

    //Area = property;
    private String Status ;
    private String ID ;
    private boolean forSale ;
    private String category;

    private String Name;
    private int price ;

    private int ownerID;

    public int getOwnerID() {
        return ownerID;
    }

    public int getPrice() {
        return price;
    }
    public String getStatus() {
        return Status;
    }

    public String getID() {
        return ID;
    }

    public boolean isForSale() {
        return forSale;
    }

    public String getCategory() {
        return category;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setForSale(boolean forSale) {
        this.forSale = forSale;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public Area(String ID, String status, boolean forSale, String category , int price , int ownerID , String name) {
        Status = status;
        this.ID = ID;
        this.forSale = forSale;
        this.category = category;
        this.price = price;
        this.ownerID = ownerID;
        this.Name = name;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    public Area(String status, String ID, boolean forSale , int price , int ownerID , String name ) {
        Status = status;
        this.ID = ID;
        this.forSale = forSale;
        this.price = price;
        this.ownerID = ownerID;
        this.Name = name;
    }

    public String toString(){
        return " ID : " + ID + "\n Status : " + Status + "\n For Sale : " + forSale + "\n Price : " + price;
    }

}
