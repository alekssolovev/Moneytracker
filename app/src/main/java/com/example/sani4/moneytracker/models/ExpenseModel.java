package com.example.sani4.moneytracker.models;


public class ExpenseModel {

    private String name;
    private  String price;

    public ExpenseModel(String name, String price){

        this.name=name;
        this.price=price;

    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }


}
