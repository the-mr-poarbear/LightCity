package com.example.lightcityfloat;

public class Company extends Area {

    private String ID;
    private String Category;
    private String Product;
    private int ProductPrice;
    private int Income;
    private String Status;
    private int OwnerID;
    private boolean ForSale;
    private int  CompanyPrice;
    public Company(String status, String ID, boolean forSale, String name, String category,
                   String product,int income, int productPrice,  int ownerID, int companyPrice) {
        super(status, ID, forSale , companyPrice , ownerID , name);
        this.Category = category;
        Product = product;
        ProductPrice = productPrice;
        Income = income;
        CompanyPrice = companyPrice;
    }
    public String getCategory() {
        return Category;
    }

    public String getProduct() {
        return Product;
    }

    public int getProductPrice() {
        return ProductPrice;
    }

    public int getIncome() {
        return Income;
    }
    public int getCompanyPrice() {
        return CompanyPrice;
    }

    @Override
    public void setID(String ID) {
        this.ID = ID;
    }

    public void setCategory(String category) {
        this.Category = category;
    }

    public void setProduct(String product) {
        Product = product;
    }

    public void setProductPrice(int productPrice) {
        ProductPrice = productPrice;
    }

    public void setIncome(int income) {
        Income = income;
    }

    public void setCompanyPrice(int companyPrice) {
        CompanyPrice = companyPrice;
    }


    public String toString(){
        return " Name : " + super.getName() + "\n Status : " + super.getStatus() + "\n For Sale : " + super.isForSale() + "\n Price : " + super.getPrice()
                + "\n Product : " + getProduct() + "\n Product Price : " + getProductPrice() + "\n Income : " + getIncome() + "\n CompanyPrice : " + getPrice()  ;
    }
}


